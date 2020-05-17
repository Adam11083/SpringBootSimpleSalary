package com.example.demo.Controller;

import com.example.demo.Model.DeductPayModel;
import com.example.demo.Model.NetPayModel;
import com.example.demo.Model.PersonSalaryModel;
import com.example.demo.Repository.PersonSalaryRepository;
import org.springframework.data.mongodb.core.aggregation.ComparisonOperators;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wx")
public class wxEnter {

    // Inject the repository
    private PersonSalaryRepository personSalaryRepository;

    public wxEnter(PersonSalaryRepository personSalaryRepository) {
        this.personSalaryRepository = personSalaryRepository;
    }

    @GetMapping("/v")
    public String login(HttpServletRequest request,
                        HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");


//        PrintWriter out = null;
//        try {
//            out = response.getWriter();
//            if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
//                out.write(echostr);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            out.close();
//        }
       return echostr;
    }

    public String QueryContent(String content, boolean IsDetail) {
        content = content.replace("详细","");
        content = content.trim();
        PersonSalaryModel Person    = this.personSalaryRepository.findByName(content).get(0);
        NetPayModel NetPay          = Person.getNetPay();
        DeductPayModel DeductPay    = Person.getDeductPay();

        String name     = Person.getName();
        float netPay    = Person.getNetPay().getNetPayTotal();
        float deductPay = Person.getDeductPay().getDeductPayTotal();
        float totalPay  = Person.getPayTotal();

        String result = "姓名："    + name+"\n"
                      + "应发工资：" + netPay    + "元\n"
                      + "应扣费用：" + deductPay + "元\n"
                      + "实发工资：" + totalPay  + "元\n";

        String resultDetail = "姓名："    + name+"\n"
                + "岗位工资："         + NetPay.getPostWage()                            + "元\n"
                + "薪级工资："         + NetPay.getPayWage()                             + "元\n"
                + "基础性绩效工资："    + NetPay.getBasicMeritPay()                       + "元\n"
                + "改革性补贴："        + NetPay.getRevolutionarySubsidy()                + "元\n"
                + "独子费："           + NetPay.getSingleChildSubsidy()                  + "元\n"
                + "回族补贴："         + NetPay.getHuiNationSubsidy()                    + "元\n"
                + "补发1-3月薪级工资：" + NetPay.getRetroactivePayWage()                   + "元\n"
                + "岗位变动补发工资："   + NetPay.getRetroactivePostChangeWage()           + "元\n"
                + "教龄津贴："         + NetPay.getSeniorityAllowance()                   + "元\n"
                + "应发工资："         + netPay                                           + "元\n"
                + "补发失业保险："      + DeductPay.getUnemploymentInsurance_Retroactive() + "元\n"
                + "三月失业保险："      + DeductPay.getUnemploymentInsurance_March()       + "元\n"
                + "二月个税："         + DeductPay.getIndividualIncomeTax_Feb()           + "元\n"
                + "四月公积金："        + DeductPay.getAccumulationFund_April()            + "元\n"
                + "四月医疗保险："      + DeductPay.getHealthInsurance_April()             + "元\n"
                + "补充医疗保险："      + DeductPay.getHealthInsurance_Additional()        + "元\n"
                + "四月养老保险："      + DeductPay.getPension_April()                     + "元\n"
                + "四月职业年金："      + DeductPay.getOccupationalPension_April()         + "元\n"
                + "应扣费用："         + deductPay                                        + "元\n"
                + "实发工资："         + totalPay                                         + "元\n";

        return IsDetail ?  resultDetail : result ;
    }

    @PostMapping("/v")
    public void dopost(HttpServletRequest request,HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        PrintWriter out = null;
        //将微信请求xml转为map格式，获取所需的参数
        Map<String,String> map = MessageUtil.xmlToMap(request);
        String ToUserName = map.get("ToUserName");
        String FromUserName = map.get("FromUserName");
        String MsgType = map.get("MsgType");
        String Content = map.get("Content");

        String message = null;
        //处理文本类型
        if ("text".equals(MsgType)) {
            TextMessageUtil textMessage = new TextMessageUtil();
            message = textMessage.initMessage(FromUserName, ToUserName, QueryContent(Content,Content.contains("详细")));
        }
        try {
            out = response.getWriter();
            out.write(message);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        out.close();
    }

}

