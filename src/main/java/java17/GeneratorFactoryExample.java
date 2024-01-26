package java17;

import java.util.Comparator;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class GeneratorFactoryExample {

    public static void main(String[] args) {
        System.out.println("All Random Generators");
        RandomGeneratorFactory.all()
                .sorted(Comparator.comparing(RandomGeneratorFactory::name))
                .forEach(factory -> System.out.println(String.format("%s\t%s\t%s\t%s",
                        factory.group(),
                        factory.name(),
                        factory.isJumpable(),
                        factory.isSplittable())));

        int random = RandomGenerator.of("SecureRandom").nextInt(100);
        System.out.println(random);
    }


    public static RandomGenerator getDefaultGenerator() {
        return RandomGeneratorFactory.getDefault().create();
    }

    public static RandomGenerator getJumpableGenerator() {
        return RandomGeneratorFactory.all()
                .filter(RandomGeneratorFactory::isJumpable)
                .findAny()
                .map(RandomGeneratorFactory::create)
                .orElseThrow(() -> new RuntimeException("Error creating a generator"));
    }

}