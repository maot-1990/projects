package com.pers.util.cacl;



import com.pers.util.base.CommonInfo;
import com.pers.util.date.DateUtils;
import com.pers.util.enums.RepaymentModeEnum;
import com.pers.util.math.ArithTools;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 根据不同的还款方式计算还款计划
 *
 * @author maot
 */
public class RepaymentModeCalc {

    /**
     * @param mode      还款方式
     * @param beginDate 起息日
     * @param endDate   到期日
     * @param loanMoney 借款金额
     * @param yearRate  借款利率(除以100后的小数)
     * @param deadLine  项目期限 ，按月：传多少个月， 按日：传多少天
     * @param deadLine  项目期限类型 ，1-按日   2-按月
     * @return
     */
    public static List<RepaymentPlanCalc> calculation(RepaymentModeEnum mode, Date beginDate, Date endDate, Double loanMoney,
                                                      Double yearRate, Integer deadLine) throws Exception {
        if (mode == null) {
            throw new Exception("还款方式不能为空");
        }
        if (beginDate == null) {
            throw new Exception("起息日不能为空");
        }
        if (endDate == null) {
            throw new Exception("到期日不能为空");
        }
        if (loanMoney == null) {
            throw new Exception("借款金额不能为空");
        }
        if (yearRate == null) {
            throw new Exception("借款利率不能为空");
        }
        if (deadLine == null) {
            throw new Exception("总期数不能为空");
        }

        List<RepaymentPlanCalc> calcs = new ArrayList<RepaymentPlanCalc>();

        if (mode.equals(RepaymentModeEnum.DAILY_INTEREST_LSBQ)) { //按日计息，利随本清
            calcs = dailyInterestLsbq(calcs, beginDate, endDate, loanMoney, yearRate, deadLine);
        } else if (mode.equals(RepaymentModeEnum.MONTH_INTEREST_LSBQ)) { //按月计息，利随本清
            calcs = monthInterestLsbq(calcs, beginDate, endDate, loanMoney, yearRate, deadLine);
        } else if (mode.equals(RepaymentModeEnum.DAILY_INTEREST_XXHB)) { //按日计息，先息后本
            calcs = dailyInterestXxhb(calcs, beginDate, endDate, loanMoney, yearRate, deadLine);
        } else if (mode.equals(RepaymentModeEnum.MONTH_INTEREST_XXHB)) { //按月计息，先息后本
            calcs = monthInterestXxhb(calcs, beginDate, endDate, loanMoney, yearRate, deadLine);
        } else if (mode.equals(RepaymentModeEnum.MONTH_INTEREST_DEBX)) { //按月计息，等额本息
            calcs = monthInterestDebx(calcs, beginDate, endDate, loanMoney, yearRate, deadLine);
        } else if (mode.equals(RepaymentModeEnum.MONTH_INTEREST_DEBJ)) { //按月计息，等额本金
            calcs = monthInterestDebj(calcs, beginDate, endDate, loanMoney, yearRate, deadLine);
        } else if (mode.equals(RepaymentModeEnum.DAILY_INTEREST_SJSH)) { //按日计息，随借随还
            calcs = dailyInterestSjsh(calcs, beginDate, endDate, loanMoney, yearRate, deadLine);
        }

        System.out.println(mode.getValue() + ",还款计划：" + calcs.toString());
        return calcs;
    }

    private static List<RepaymentPlanCalc> dailyInterestLsbq(List<RepaymentPlanCalc> calcs, Date beginDate, Date endDate,
                                                             Double loanMoney, Double yearRate, Integer deadLine) throws Exception {

        double interest = ArithTools.scale(ArithTools.div(ArithTools.mul(ArithTools.mul(loanMoney, yearRate),
                deadLine), CommonInfo.YEAR_DAY_ALL), 2);
        RepaymentPlanCalc calc = new RepaymentPlanCalc();
        calc.setBeginDate(beginDate);
        calc.setEndDate(endDate);
        calc.setCaptial(loanMoney);
        calc.setInterest(interest);
        calc.setPeriod(1);
        calc.setTotalMoney(ArithTools.add(calc.getCaptial(), calc.getInterest()));
        calcs.add(calc);
        return calcs;
    }

    private static List<RepaymentPlanCalc> monthInterestLsbq(List<RepaymentPlanCalc> calcs, Date beginDate, Date endDate,
                                                             Double loanMoney, Double yearRate, Integer deadLine) throws Exception {
        double interest = ArithTools.scale(ArithTools.div(ArithTools.mul(ArithTools.mul(loanMoney, yearRate),
                deadLine), CommonInfo.YEAR_MONTH), 2);
        RepaymentPlanCalc calc = new RepaymentPlanCalc();
        calc.setBeginDate(beginDate);
        calc.setEndDate(endDate);
        calc.setCaptial(loanMoney);
        calc.setInterest(interest);
        calc.setPeriod(1);
        calc.setTotalMoney(ArithTools.add(calc.getCaptial(), calc.getInterest()));
        calcs.add(calc);
        return calcs;
    }

    private static List<RepaymentPlanCalc> dailyInterestXxhb(List<RepaymentPlanCalc> calcs, Date beginDate, Date endDate,
                                                             Double loanMoney, Double yearRate, Integer deadLine) throws Exception {
        deadLine = ArithTools.roundUp(ArithTools.div(deadLine, CommonInfo.DAY_MONTH));
        int day = DateUtils.getDayByDate(beginDate);
        for (int i = 1; i <= deadLine; i++) {
            RepaymentPlanCalc calc = new RepaymentPlanCalc();
            Date expiredDate = null;
            if (i < deadLine) {
                expiredDate = DateUtils.addMonth(beginDate, 1);
                int maxDay = DateUtils.getLastDayByDate(expiredDate);
                int currentDay = DateUtils.getDayByDate(expiredDate);
                if (currentDay < day && maxDay >= day) {
                    expiredDate = DateUtils.setDayByDate(expiredDate, day);
                }
                calc.setCaptial(0.00);
            } else {
                expiredDate = endDate;
                calc.setCaptial(loanMoney);
            }
            double interest = ArithTools.scale(ArithTools.div(ArithTools.mul(ArithTools.mul(loanMoney, yearRate),
                    DateUtils.subDay(beginDate, expiredDate)), CommonInfo.YEAR_DAY_ALL), 2);
            calc.setBeginDate(beginDate);
            calc.setEndDate(expiredDate);
            calc.setInterest(interest);
            calc.setPeriod(i);
            calc.setTotalMoney(ArithTools.add(calc.getCaptial(), calc.getInterest()));
            calcs.add(calc);
            //重置下一期的起息日
            beginDate = expiredDate;
        }
        return calcs;
    }

    private static List<RepaymentPlanCalc> monthInterestXxhb(List<RepaymentPlanCalc> calcs, Date beginDate, Date endDate,
                                                             Double loanMoney, Double yearRate, Integer deadLine) throws Exception {
        int day = DateUtils.getDayByDate(beginDate);
        for (int i = 1; i <= deadLine; i++) {
            RepaymentPlanCalc calc = new RepaymentPlanCalc();
            Date expiredDate = null;
            if (i < deadLine) {
                expiredDate = DateUtils.addMonth(beginDate, 1);
                int maxDay = DateUtils.getLastDayByDate(expiredDate);
                int currentDay = DateUtils.getDayByDate(expiredDate);
                if (currentDay < day && maxDay >= day) {
                    expiredDate = DateUtils.setDayByDate(expiredDate, day);
                }
                calc.setCaptial(0.00);
            } else {
                expiredDate = endDate;
                calc.setCaptial(loanMoney);
            }
            double interest = ArithTools.scale(ArithTools.div(ArithTools.mul(ArithTools.mul(loanMoney, yearRate),
                    1), CommonInfo.YEAR_MONTH), 2);
            calc.setBeginDate(beginDate);
            calc.setEndDate(expiredDate);
            calc.setInterest(interest);
            calc.setPeriod(i);
            calc.setTotalMoney(ArithTools.add(calc.getCaptial(), calc.getInterest()));
            calcs.add(calc);
            //重置下一期的起息日
            beginDate = expiredDate;
        }
        return calcs;
    }

    /**
     * 按月计息，等额本息
     * 公式：
     * 每月月供额=(贷款本金×月利率×(1＋月利率)＾还款月数)÷((1＋月利率)＾还款月数-1)
     * 每月应还利息=贷款本金×月利率×((1+月利率)^还款月数-(1+月利率)^(还款月序号-1))÷((1+月利率)^还款月数-1)
     * 每月应还本金=贷款本金×月利率×(1+月利率)^(还款月序号-1)÷((1+月利率)^还款月数-1)
     *
     * @param calcs
     * @param beginDate
     * @param endDate
     * @param loanMoney
     * @param yearRate
     * @param deadLine
     * @return
     * @throws Exception
     */
    private static List<RepaymentPlanCalc> monthInterestDebx(List<RepaymentPlanCalc> calcs, Date beginDate, Date endDate,
                                                             Double loanMoney, Double yearRate, Integer deadLine) throws Exception {
        int day = DateUtils.getDayByDate(beginDate);
        double tempLoanMoney = 0.0;
        double total = ArithTools.scale(ArithTools.div((ArithTools.mul(ArithTools.mul(loanMoney, ArithTools.div(yearRate, CommonInfo.YEAR_MONTH)),
                ArithTools.exp((1+ArithTools.div(yearRate, CommonInfo.YEAR_MONTH)), deadLine))), (ArithTools.exp((1+ArithTools.div(yearRate, CommonInfo.YEAR_MONTH)), deadLine)-1)), 2);
        for (int i = 1; i <= deadLine; i++) {
            double captial = ArithTools.scale(ArithTools.div(ArithTools.mul(ArithTools.mul(loanMoney, ArithTools.div(yearRate, CommonInfo.YEAR_MONTH)),
                    ArithTools.exp((1+ArithTools.div(yearRate, CommonInfo.YEAR_MONTH)),(i-1))), (ArithTools.exp((1+ArithTools.div(yearRate, CommonInfo.YEAR_MONTH)),deadLine)-1)), 2);
            RepaymentPlanCalc calc = new RepaymentPlanCalc();
            Date expiredDate = null;
            if (i < deadLine) {
                expiredDate = DateUtils.addMonth(beginDate, 1);
                int maxDay = DateUtils.getLastDayByDate(expiredDate);
                int currentDay = DateUtils.getDayByDate(expiredDate);
                if (currentDay < day && maxDay >= day) {
                    expiredDate = DateUtils.setDayByDate(expiredDate, day);
                }
                calc.setCaptial(captial);
                calc.setInterest(ArithTools.sub(total, captial, 2));
                tempLoanMoney = ArithTools.add(tempLoanMoney, captial);
            } else {
                expiredDate = endDate;
                calc.setCaptial(ArithTools.sub(loanMoney, tempLoanMoney));
                calc.setInterest(ArithTools.sub(total, calc.getCaptial()));
            }
            calc.setBeginDate(beginDate);
            calc.setEndDate(expiredDate);
            calc.setPeriod(i);
            calc.setTotalMoney(ArithTools.add(calc.getCaptial(), calc.getInterest()));
            calcs.add(calc);
            //重置下一期的起息日
            beginDate = expiredDate;
        }
        return calcs;
    }

    /**
     * 按月计息，等额本金
     * 公式：
     * 每月月供额=(贷款本金÷还款月数)+(贷款本金-已归还本金累计额)×月利率
     * 每月应还本金=贷款本金÷还款月数
     * 每月应还利息=剩余本金×月利率=(贷款本金-已归还本金累计额)×月利率
     * @param calcs
     * @param beginDate
     * @param endDate
     * @param loanMoney
     * @param yearRate
     * @param deadLine
     * @return
     * @throws Exception
     */
    private static List<RepaymentPlanCalc> monthInterestDebj(List<RepaymentPlanCalc> calcs, Date beginDate, Date endDate,
                                                             Double loanMoney, Double yearRate, Integer deadLine) throws Exception {
        int day = DateUtils.getDayByDate(beginDate);
        double alreadyRepayCaptial = 0.0;
        double captial = ArithTools.div(loanMoney, deadLine, 2);
        for (int i = 1; i <= deadLine; i++) {
            double interest = ArithTools.mul(ArithTools.sub(loanMoney, alreadyRepayCaptial), ArithTools.div(yearRate, CommonInfo.YEAR_MONTH), 2);
            RepaymentPlanCalc calc = new RepaymentPlanCalc();
            Date expiredDate = null;
            if (i < deadLine) {
                expiredDate = DateUtils.addMonth(beginDate, 1);
                int maxDay = DateUtils.getLastDayByDate(expiredDate);
                int currentDay = DateUtils.getDayByDate(expiredDate);
                if (currentDay < day && maxDay >= day) {
                    expiredDate = DateUtils.setDayByDate(expiredDate, day);
                }
                calc.setCaptial(captial);
                alreadyRepayCaptial = ArithTools.add(alreadyRepayCaptial, captial);
            } else {
                expiredDate = endDate;
                calc.setCaptial(ArithTools.sub(loanMoney, alreadyRepayCaptial));
            }
            calc.setInterest(interest);
            calc.setBeginDate(beginDate);
            calc.setEndDate(expiredDate);
            calc.setPeriod(i);
            calc.setTotalMoney(ArithTools.add(calc.getCaptial(), calc.getInterest()));
            calcs.add(calc);
            //重置下一期的起息日
            beginDate = expiredDate;
        }
        return calcs;
    }

    private static List<RepaymentPlanCalc> dailyInterestSjsh(List<RepaymentPlanCalc> calcs, Date beginDate, Date endDate,
                                                             Double loanMoney, Double yearRate, Integer deadLine) throws Exception {
        RepaymentPlanCalc calc = new RepaymentPlanCalc();
        calc.setBeginDate(beginDate);
        calc.setEndDate(endDate);
        calc.setCaptial(loanMoney);
        calc.setInterest(0.00);
        calc.setPeriod(1);
        calc.setTotalMoney(ArithTools.add(calc.getCaptial(), calc.getInterest()));
        calcs.add(calc);
        return calcs;
    }

}
