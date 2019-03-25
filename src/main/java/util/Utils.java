package util;

public class Utils {
    public static String runContext = "import string.Utils\n" +
            "\n" +
            "class Test {\n" +
            "    void m(long l) { // 1\n" +
            "        println \"in m(long)\"\n" +
            "    }\n" +
            "    void m(Integer i) { //2\n" +
            "        println \"in m(Integer)\"\n" +
            "    }\n" +
            "    void m(int i) { //2\n" +
            "        println \"in m(int)\"\n" +
            "    }\n" +
            "\n" +
            "    static m(String a){\n" +
            "        println(\"in m(String)\")\n" +
            "    }\n" +
            "     static void main (String[] args){\n" +
            "         long i = 1\n" +
            "         Test test = new Test()\n" +
            "         test.m(i)\n" +
            "         m(\"c\")\n" +
            "         println(\"dd\"+Utils.runContext)\n" +
            "    }\n" +
            "\n" +
            "}\n";
}
