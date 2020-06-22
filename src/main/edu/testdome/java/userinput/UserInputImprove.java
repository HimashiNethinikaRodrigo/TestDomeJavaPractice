package main.edu.testdome.java.userinput;

public class UserInputImprove {
    public static class TextInput {
        public String currentValue;
        private final StringBuilder builder = new StringBuilder();
        public void add(char c) {
            currentValue=builder.append(c).toString();
        }

        public String getValue() {
            return currentValue;
        }
    }

    public static class NumericInput extends TextInput {
        @Override
        public void add(char c) {
            if (Character.isDigit(c))
                super.add(c);
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
