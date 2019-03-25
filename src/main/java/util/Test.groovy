package util

class Test {
    void m(long l) { // 1
        println "in m(long)"
    }
    void m(Integer i) { //2
        println "in m(Integer)"
    }
    void m(int i) { //2
        println "in m(int)"
    }

    static m(String a){
        println("in m(String)")
    }
     static void main (String[] args){
         long i = 1
         Test test = new Test()
         test.m(i)
         m("c")
         println("dd"+Utils.runContext)
    }

}
