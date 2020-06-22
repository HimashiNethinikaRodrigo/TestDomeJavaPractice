package main.edu.testdome.java.userinput;

public class UserInput {
    public static class TextInput {
        public String currentValue;
        StringBuilder builder = new StringBuilder();
        public void add(char c) {
            currentValue=builder.append(c).toString();
        }

        public String getValue() {
            return currentValue;
        }
    }

    public static class NumericInput extends TextInput {
        public void add(char c) {
            try {
                Integer.parseInt(String.valueOf(c));
                currentValue=builder.append(c).toString();
            }catch (NumberFormatException e){

            }
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
