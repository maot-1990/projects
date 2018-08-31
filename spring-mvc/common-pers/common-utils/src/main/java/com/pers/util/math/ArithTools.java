package com.pers.util.math;

import java.math.BigDecimal;

/**
 * 算术工具类
 *
 * @author maot
 */
public class ArithTools {

    public static Double add(Double d1, Double d2, Integer... scale) {
        Integer realScale = 16;
        if (d1 == null) {
            d1 = 0.0;
        }
        if (d2 == null) {
            d2 = 0.0;
        }
        if (scale != null && scale.length > 0) {
            realScale = scale[0];
        }
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(d1));
        BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d2));
        return bigDecimal1.add(bigDecimal2).setScale(realScale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    public static Double sub(Double d1, Double d2, Integer... scale) {
        Integer realScale = 16;
        if (d1 == null) {
            d1 = 0.0;
        }
        if (d2 == null) {
            d2 = 0.0;
        }
        if (scale != null && scale.length > 0) {
            realScale = scale[0];
        }
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(d1));
        BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d2));
        return bigDecimal1.subtract(bigDecimal2).setScale(realScale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    public static Double mul(Double d1, Double d2, Integer... scale) {
        Integer realScale = 16;
        if (d1 == null) {
            d1 = 0.0;
        }
        if (d2 == null) {
            d2 = 0.0;
        }
        if (scale != null && scale.length > 0) {
            realScale = scale[0];
        }
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(d1));
        BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d2));
        return bigDecimal1.multiply(bigDecimal2).setScale(realScale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    public static Double mul(Double d1, Integer i2, Integer... scale) {
        Integer realScale = 16;
        if (d1 == null) {
            d1 = 0.0;
        }
        if (i2 == null) {
            i2 = 0;
        }
        if (scale != null && scale.length > 0) {
            realScale = scale[0];
        }
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(d1));
        BigDecimal bigDecimal2 = new BigDecimal(Integer.toString(i2));
        return bigDecimal1.multiply(bigDecimal2).setScale(realScale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    public static Double div(Double d1, Double d2, Integer... scale) throws Exception {
        Integer realScale = 16;
        if (d1 == null) {
            d1 = 0.0;
        }
        if (d2 == null && d2 == 0) {
            throw new Exception("参数不合法，除数不能为零");
        }
        if (scale != null && scale.length > 0) {
            realScale = scale[0];
        }
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(d1));
        BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d2));
        return bigDecimal1.divide(bigDecimal2, realScale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    public static Double div(Double d1, Integer i2, Integer... scale) throws Exception {
        Integer realScale = 16;
        if (d1 == null) {
            d1 = 0.0;
        }
        if (i2 == null && i2 == 0) {
            throw new Exception("参数不合法，除数不能为零");
        }
        if (scale != null && scale.length > 0) {
            realScale = scale[0];
        }
        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(d1));
        BigDecimal bigDecimal2 = new BigDecimal(Integer.toString(i2));
        return bigDecimal1.divide(bigDecimal2, realScale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    public static Double scale(Double d, Integer scale) {
        if (d == null) {
            d = 0.0;
        }
        BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
        return bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 向上取整
     * @param d
     * @return
     */
    public static Integer roundUp(Double d) {
        if (d == null) {
            d = 0.0;
        }
        BigDecimal bigDecimal = new BigDecimal(Double.toString(d));
        return bigDecimal.setScale(0, BigDecimal.ROUND_UP).intValue();
    }

    public static Integer add(Integer i1, Integer i2) {
        if (i1 == null) {
            i1 = 0;
        }
        if (i2 == null) {
            i2 = 0;
        }
        BigDecimal bigDecimal1 = new BigDecimal(Integer.toString(i1));
        BigDecimal bigDecimal2 = new BigDecimal(Integer.toString(i2));
        return bigDecimal1.add(bigDecimal2).intValue();
    }

    public static Integer sub(Integer i1, Integer i2) {
        if (i1 == null) {
            i1 = 0;
        }
        if (i2 == null) {
            i2 = 0;
        }
        BigDecimal bigDecimal1 = new BigDecimal(Integer.toString(i1));
        BigDecimal bigDecimal2 = new BigDecimal(Integer.toString(i2));
        return bigDecimal1.subtract(bigDecimal2).intValue();
    }

    public static Integer mul(Integer i1, Integer i2) {
        if (i1 == null) {
            i1 = 0;
        }
        if (i2 == null) {
            i2 = 0;
        }
        BigDecimal bigDecimal1 = new BigDecimal(Integer.toString(i1));
        BigDecimal bigDecimal2 = new BigDecimal(Integer.toString(i2));
        return bigDecimal1.multiply(bigDecimal2).intValue();
    }

    public static Double div(Integer i1, Integer i2, Integer... scale) throws Exception {
        Integer realScale = 16;
        if (i1 == null) {
            i1 = 0;
        }
        if (i2 == null && i2 == 0) {
            throw new Exception("参数不合法，除数不能为零");
        }
        if (scale != null && scale.length > 0) {
            realScale = scale[0];
        }
        BigDecimal bigDecimal1 = new BigDecimal(Integer.toString(i1));
        BigDecimal bigDecimal2 = new BigDecimal(Integer.toString(i2));
        return bigDecimal1.divide(bigDecimal2, realScale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static Double exp(Double d1, Integer d2, Integer... scale) throws Exception {
        Integer realScale = 16;
        if (d1 == null) {
            d1 = 0.0;
        }
        if (d2 == null) {
            d2 = 0;
        }
        if (scale != null && scale.length > 0) {
            realScale = scale[0];
        }
        return new BigDecimal(Double.toString(Math.pow(d1, d2))).setScale(realScale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }
}
