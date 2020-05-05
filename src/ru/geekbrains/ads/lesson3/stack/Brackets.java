package ru.geekbrains.ads.lesson3.stack;

public class Brackets {

    public static void main(String[] args) {
        String text = "    public static void main(String[] args) {        testStack();//        testQueue();    }";
        new Brackets(text).check();
    }

    private final String text;

    public Brackets(String text) {
        this.text = text;
    }

    public void check() {
        Stack<Character> stack = new StackImpl<>(text.length());
        for (int index = 0; index < text.length(); index++) {
            char currentChar = text.charAt(index);
            checkCurrentChar(currentChar, index, stack);
//            String msg = checkCurrentChar(currentChar, index, stack);
//            if (msg != null) {
//                System.out.println(msg);
//            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter!");
        }
    }

    private void checkCurrentChar(char currentChar, int charIndex, Stack<Character> stack) {
        switch (currentChar) {
            case '{':
            case '[':
            case '(':
                stack.push(currentChar);
                break;
            case '}':
            case ']':
            case ')':
                if (stack.isEmpty()) {
                    System.out.println("Error: " + currentChar + " at " + charIndex);
                    break;
                }

                Character lastOpenedBracket = stack.pop();
                if (lastOpenedBracket == '{' && currentChar != '}' ||
                lastOpenedBracket == '[' && currentChar != ']' ||
                lastOpenedBracket == '(' && currentChar != ')') {
                    System.out.println("Error: " + currentChar + " at " + charIndex);
                }
        }
    }

//    private String checkCurrentChar(char currentChar, int charIndex, Stack<Character> stack) {
//        return switch (currentChar) {
//            case '{', '[', '(' -> {
//                stack.push(currentChar);
//                yield null;
//            }
//            case '}', ']', ')' -> {
//                String result = null;
//                String errMsg = "Error: " + currentChar + " at " + charIndex;
//
//                if (stack.isEmpty()) {
//                    result = errMsg;
//                } else {
//                    Character lastOpenedBracket = stack.pop();
//                    if (lastOpenedBracket == '{' && currentChar != '}' ||
//                            lastOpenedBracket == '[' && currentChar != ']' ||
//                            lastOpenedBracket == '(' && currentChar != ')') {
//                        result = errMsg;
//                    }
//                }
//                yield result;
//            }
//            default -> null;
//        };
//    }

}
