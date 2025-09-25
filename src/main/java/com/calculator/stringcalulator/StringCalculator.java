package com.calculator.stringcalulator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String numbers){
        if(numbers == null || numbers.isEmpty()){
            return 0;
        }
        String nums = numbers;
        String delimiter = ",|\n";
        if(numbers.startsWith("//")){
            int newdelIndex = numbers.indexOf('\n');
            if(newdelIndex == -1){
                throw new IllegalArgumentException("Invalid input: missing newline after custom delimiter");
            }
            String customDelimiter = numbers.substring(2, newdelIndex);
            delimiter = Pattern.quote(customDelimiter);
            nums = numbers.substring(newdelIndex + 1);

        }
        String tokens[] = nums.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        for(String token : tokens){
            if(token.isEmpty()){
                continue;
            }
            int num;
            try{
                num = Integer.parseInt(token);
            } catch (NumberFormatException e){
                throw new IllegalArgumentException("Invalid number: " + token);
            }
            if(num < 0){
                negatives.add(num);
            } else if(num <= 1000){
                sum += num;
            }
            if(!negatives.isEmpty()){
                String negs = negatives.stream().map(Object::toString).collect(Collectors.joining(", "));
                throw new IllegalArgumentException("Negatives not allowed: " + negs);
            }
        }

        return sum;
    }

}
