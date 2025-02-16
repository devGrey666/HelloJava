import core.java8.lambda.*;

public class Main {
    public static void main(String[] args) {
//        var predicateFilter = new PredicateExample();
//        predicateFilter.run();
//
//
////     use consumer to print the list of strings
//        var consumerExample = new ConsumerExample();
//        consumerExample.run();
//
////        use function to map the list of strings to their lengths
//        var functionExample = new FunctionExample();
//        functionExample.run();


//        compare the list of persons by age and then by name
        var comparing = new Comparing();
        comparing.run();

//        compose two functions
        var composingFunctions = new ComposingFunctions();
        composingFunctions.run();

    }


}