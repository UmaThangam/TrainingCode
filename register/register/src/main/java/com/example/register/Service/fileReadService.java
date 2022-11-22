package com.example.register.Service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class fileReadService {

    public List<Map<String ,String>> fileRead(String filepath) throws IOException {
        FileReader fileReader=new FileReader(filepath);
        BufferedReader buffer = new BufferedReader(fileReader);
        List<Map<String,String>> mapList1=new ArrayList<>();
        List<Map<String,String>> mapList2=new ArrayList<>();
        List<Map<String,String>> mapList3=new ArrayList<>();
        String line=" " , firstThreeDigit=" ";
        line = buffer.readLine();
       while(line!=null){
            firstThreeDigit = line.substring(0, 3);
            if (firstThreeDigit.equals(" ")) {
                Map<String, String> map1 = new HashMap<>();
                map1.put("Record Type", firstThreeDigit);
                map1.put("Hierarchy ID", line.substring(3, 20));
                map1.put("Hierarchy Level No", line.substring(20, 25));
                map1.put("Date", line.substring(25, 33));
                map1.put("Merchant Name", line.substring(33, 98));
                map1.put("Filler", line.substring(98, 999));
                mapList1.add(map1);
            } else if (firstThreeDigit.equals("009")) {
                Map<String, String> map = new HashMap<>();
                map.put("Record Type", firstThreeDigit);
                map.put("Hierarchy ID", line.substring(3, 20));
                map.put("Hierarchy Level No", line.substring(20, 25));
                map.put("Location ID", line.substring(25, 45));
                map.put("Location DBA Name", line.substring(45, 125));
                map.put("Store Number", line.substring(125, 135));
                map.put("External ID", line.substring(135, 160));
                map.put("Dispute Type", line.substring(160, 220));
                map.put("Request Type", line.substring(220, 221));
                map.put("Status Date", line.substring(221, 229));
                map.put("Status Description", line.substring(229, 239));
                map.put("Request Date", line.substring(239, 247));
                map.put("Chargeback Currency Code", line.substring(247, 250));
                map.put("Dispute Amount Sign", line.substring(250, 251));
                map.put("Dispute Amount", line.substring(251, 266));
                map.put("Reason Code", line.substring(266, 270));
                map.put("Reason Code Description", line.substring(270, 370));
                map.put("IDS Case Number", line.substring(370, 390));
                map.put("Due Date", line.substring(390, 398));
                map.put("Acquirer Reference Number", line.substring(398, 428));
                map.put("Chargeback Cycle", line.substring(428, 429));
                map.put("First Chargeback Date", line.substring(429, 437));
                map.put("Second Chargeback Date", line.substring(437, 445));
                map.put("Card Type", line.substring(455, 465));
                map.put("Card Number", line.substring(465, 490));
                map.put("Exp. Date", line.substring(490, 494));
                map.put("Adjustment Date", line.substring(494, 502));
                map.put("Transaction Date", line.substring(502, 510));
                map.put("Batch Date", line.substring(510, 518));
                map.put("Batch Number", line.substring(518, 538));
                map.put("Processed Transaction Currency Code", line.substring(538, 541));
                map.put("Processed Transaction Amount Sign", line.substring(541, 542));
                map.put("Processed Transaction Amount", line.substring(542, 557));
                map.put("Authorization Code", line.substring(557, 565));
                map.put("Invoice Number", line.substring(565, 585));
                map.put("Airline Ticket Number", line.substring(585, 605));
                map.put("SIC Code", line.substring(605, 609));
                map.put("Receive Date", line.substring(609, 617));
                map.put("Adjustment Amount Sign", line.substring(617, 618));
                map.put("Adjustment Amount", line.substring(618, 633));
                map.put("SubMerchant ID", line.substring(633, 653));
                map.put("Soft Descriptor", line.substring(653, 655));
                map.put("Special Reference  #2", line.substring(655, 680));
                map.put("Submitted Transaction Currency Code", line.substring(680, 683));
                map.put("Submitted Transaction Amount Sign", line.substring(683, 684));
                map.put("Submitted Transaction Amount", line.substring(684, 699));
                map.put("Transaction Service Code", line.substring(699, 702));
                map.put("Transaction POS Entry Mode", line.substring(702, 704));
                map.put("Work Type", line.substring(704, 724));
                map.put("Loan Number", line.substring(724, 744));
                map.put("Work Order Number", line.substring(744, 774));
                map.put("Mobile Indicator", line.substring(774, 776));
                map.put("User Data 2", line.substring(776, 921));
                map.put("Special Reference #1", line.substring(921, 951));
                map.put("CB Response Received", line.substring(951, 952));
                map.put("Current Status", line.substring(952, 977));
                map.put("Responded on Date", line.substring(977, 985));
                map.put("Debit Network ID", line.substring(985, 995));
                // map.put("Debit Network Description",line.substring(995,1020));
                // map.put("Custom Tracking",line.substring(1020,1050));
                // map.put("Pre Dispute Flag",line.substring(1050,1051));
                mapList2.add(map);
            }
            else if (firstThreeDigit.equals("011")) {
                Map<String, String> mapTwo = new HashMap<>();
                mapTwo.put("Record Type",firstThreeDigit);
                mapTwo.put("Hierarchy ID", line.substring(3, 20));
                mapTwo.put("Hierarchy Level No", line.substring(20, 25));
                mapTwo.put("Location ID", line.substring(25, 45));
                mapTwo.put("Location DBA Name", line.substring(45, 125));
                mapTwo.put("Store Number", line.substring(125, 135));
                mapTwo.put("External ID", line.substring(135, 160));
                mapTwo.put("Currency Code", line.substring(160, 163));
                mapTwo.put("Total Retrieval Requests", line.substring(163, 175));
                mapTwo.put("Total Retrieval Request Amount Sign", line.substring(175, 176));
                mapTwo.put("Total Retrieval Request Amount", line.substring(176, 185));
                mapTwo.put("Total Chargeback Requests", line.substring(185, 197));
                mapTwo.put("Total Chargeback Amount Sign", line.substring(197, 198));
                mapTwo.put("Total Chargeback Amount", line.substring(198, 217));
                mapTwo.put("Total Reversals", line.substring(217, 229));
                mapTwo.put("Total Reversals Amount Sign", line.substring(229, 230));
                mapTwo.put("Total Reversals Amount ", line.substring(230, 249));
                mapTwo.put("Total Pre-Notes", line.substring(249, 261));
                mapTwo.put("Total Pre- Note Amount Sign", line.substring(261, 262));
                mapTwo.put("Total Pre-Note Amount ", line.substring(262, 281));
                mapTwo.put("Total Pre- Arbitration", line.substring(281, 293));
                mapTwo.put("Total Pre-Arbitration Amount Sign", line.substring(293, 294));
                mapTwo.put("Total Pre-Arbitration Amount ", line.substring(294, 313));
                mapTwo.put("Total Pre- Compliance", line.substring(313, 325));
                mapTwo.put("Total Pre-Compliance Amount Sign", line.substring(325, 326));
                mapTwo.put("Total Pre-Compliance Amount ", line.substring(326, 345));
                mapTwo.put("Total Filed Arbitration", line.substring(345, 357));
                mapTwo.put("Total Filed Arbitration Amount Sign", line.substring(357, 358));
                mapTwo.put("Total Filed Arbitration Amount ", line.substring(358, 377));
                mapTwo.put("Total Filed Compliance", line.substring(377, 389));
                mapTwo.put("Total Filed Compliance Amount Sign", line.substring(389, 390));
                mapTwo.put("Total Filed Compliance Amount ", line.substring(390, 409));
                mapTwo.put("Total Collection", line.substring(409, 421));
                mapTwo.put("Total Collection Amount Sign", line.substring(421, 422));
                mapTwo.put("Total Collection Amount ", line.substring(422, 441));
                mapList3.add(mapTwo);
            }
        }
        return mapList3;
    }
}
