package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public Solution() {

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recurse(final String expression, int countOperation) {
        String temp = expression;
        Pattern patPar = Pattern.compile("\\(([^()]*)\\)");
        Pattern patrem = Pattern.compile("\\((-?[\\d.]+)\\)");
        Pattern pow = Pattern.compile("(-?[\\d.]+)(\\^)(-?[\\d.]+)");
        Pattern sin = Pattern.compile("()(sin|cos|tan)(-?[\\d.]+)");
        Pattern mul = Pattern.compile("(-?[\\d.]+)([*/])(-?[\\d.]+)");
        Pattern additive = Pattern.compile("(-?[\\d.]+)?([+M])(-?[\\d.]+)");
        Pattern plusser = Pattern.compile("(--)([\\d.]+)");

        if (countOperation == 0) {
            temp = temp.replaceAll("-", "M");
        }
        temp = temp.replaceAll(" +", "");
        String calctemp = temp;
        int start = 0;
        int end = calctemp.length();
        Matcher mathPar = patPar.matcher(temp);
        if (mathPar.find()) {
            calctemp = mathPar.group(1);
            start = mathPar.start() + 1;
            end = mathPar.end() - 1;
        }

        String result = calc(calctemp, sin);
        final String s = temp.length() == end ? "" : temp.substring(end);
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0, start) + result + s;
            recurse(temp, countOperation);
            return;
        }

        result = calc(calctemp, pow);//степень
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0, start) + result + s;
            recurse(temp, countOperation);
            return;
        }

        result = calc(calctemp, mul);
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0, start) + result + s;
            recurse(temp, countOperation);
            return;
        }

        result = calc(calctemp, plusser);
        if (!result.equals("")) {
            temp = temp.substring(0, start) + result + s;
            recurse(temp, countOperation);
            return;
        }

        result = calc(calctemp, additive);
        if (!result.equals("")) {
            countOperation++;
            temp = temp.substring(0, start) + result + s;
            recurse(temp, countOperation);
            return;
        }

        mathPar = patrem.matcher(temp);
        if (mathPar.find()) {
            temp = temp.substring(0, start - 1) + mathPar.group(1) + temp.substring(end + 1);
            recurse(temp, countOperation);
            return;
        }
        NumberFormat nf = new DecimalFormat("#.##");
        Double d = Double.parseDouble(temp);
        System.out.println(String.format("%s %d", nf.format(d), countOperation).replace(",", "."));
    }

    private String calc(String temp, Pattern pattern) {
        String result = "";
        Matcher matcher = pattern.matcher(temp);

        if (matcher.find()) {
            result = temp.replaceFirst(pattern.pattern(), numerate(matcher));
        }
        return result;
    }

    private String numerate(Matcher matcher) {
        HashMap<String, DoubleBinaryOperator> hashMap = new HashMap<>();
        hashMap.put("*", (double a, double b) -> a * b);
        hashMap.put("/", (double a, double b) -> a / b);
        hashMap.put("M", (double a, double b) -> a - b);
        hashMap.put("+", Double::sum);
        hashMap.put("++", (double a, double b) -> b);
        hashMap.put("M-", (double a, double b) -> b);
        hashMap.put("^", Math::pow);
        hashMap.put("cos", (double a, double b) -> Math.cos(Math.toRadians(b)));
        hashMap.put("sin", (double a, double b) -> Math.sin(Math.toRadians(b)));
        hashMap.put("tan", (double a, double b) -> Math.tan(Math.toRadians(b)));
        String left = "0";
        String right = "0";
        try {
            left = matcher.group(1).equals("") ? "0" : matcher.group(1);
        } catch (Exception ignored) {
        }
        try {
            right = matcher.group(3).equals("") ? "0" : matcher.group(3);
        } catch (Exception ignored) {
        }
        double dleft = Double.parseDouble(left);
        double dright = Double.parseDouble(right);
        Double result = hashMap.get(matcher.group(2)).applyAsDouble(dleft, dright);

        NumberFormat nf = new DecimalFormat("#.##");

        return String.format("%s", nf.format(result)).replace(",", ".");
    }
}