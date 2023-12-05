import java.util.Random;

public class TI {
    public static void main(String[] args) {
        int sampleSize = 100;

        // Пуасоновий розподіл
        double alphaPoisson = 2.0;
        generateAndPrintPoissonSample(alphaPoisson, sampleSize);

        // Геометричний розподіл
        double pGeometric = 0.2;
        generateAndPrintGeometricSample(pGeometric, sampleSize);

        // Біноміальний розподіл
        int nBinomial = 2;//кількість випрбувань
        double pBinomial = 0.2;//імовірність 
        generateAndPrintBinomialSample(nBinomial, pBinomial, sampleSize);

        // Рівномірний розподіл
        double aUniform = 1.0;
        double bUniform = 4.0;
        generateAndPrintUniformSample(aUniform, bUniform, sampleSize);

        // Експоненціальний розподіл
        double alphaExponential = 0.5;
        generateAndPrintExponentialSample(alphaExponential, sampleSize);

        // Нормальний розподіл
        double meanNormal = 5.0;//середнє значення
        double stdDevNormal = 2.0;//стандартне відхилення
        generateAndPrintNormalSample(meanNormal, stdDevNormal, sampleSize);
    }

    private static void generateAndPrintPoissonSample(double lambda, int size) {
        double[] sample = generatePoissonSample(lambda, size);
        printSample("Пуасоновий", sample);
    }

    private static void generateAndPrintGeometricSample(double p, int size) {
        double[] sample = generateGeometricSample(p, size);
        printSample("Геометричний", sample);
    }

    private static void generateAndPrintBinomialSample(int n, double p, int size) {
        double[] sample = generateBinomialSample(n, p, size);
        printSample("Бiномiальний", sample);
    }

    private static void generateAndPrintUniformSample(double a, double b, int size) {
        double[] sample = generateUniformSample(a, b, size);
        printSample("Рiвномiрний", sample);
    }

    private static void generateAndPrintExponentialSample(double alpha, int size) {
        double[] sample = generateExponentialSample(alpha, size);
        printSample("Експоненцiальний", sample);
    }

    private static void generateAndPrintNormalSample(double mean, double stdDev, int size) {
        double[] sample = generateNormalSample(mean, stdDev, size);
        printSample("Нормальний", sample);
    }

    private static void printSample(String distribution, double[] sample) {
        System.out.println("Розподiл: " + distribution);
        printFormattedTable(sample, 10);
        double mean = calculateMean(sample);
        double variance = calculateVariance(sample, mean);
        System.out.printf("Вибiркове середнє: %.3f\n", mean);
        System.out.printf("Вибiркова дисперсiя: %.3f\n", variance);
        System.out.println();
    }
    private static void printFormattedTable(double[] data, int rowSize) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%.3f\t", data[i]);
            if ((i + 1) % rowSize == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static double[] generatePoissonSample(double lambda, int size) {
        Random random = new Random();
        double[] sample = new double[size];
    
        for (int i = 0; i < size; i++) {
            double L = Math.exp(-lambda);
            double p = 1.0;
            int k = 0;
            do {
                k++;
                p *= random.nextDouble();
            } while (p > L);
            sample[i] = k - 1;
        }
    
        return sample;
    }

    private static double[] generateGeometricSample(double p, int size) {
        Random random = new Random();
        double[] sample = new double[size];
        for (int i = 0; i < size; i++) {
            double randomProbability = random.nextDouble();
            double geometricValue = Math.log(1 - randomProbability) / Math.log(1 - p);
            sample[i] = Math.ceil(geometricValue);
        }
        return sample;
    }

    private static double[] generateBinomialSample(int n, double p, int size) {
        Random random = new Random();
        double[] sample = new double[size];
        for (int i = 0; i < size; i++) {
            int successes = 0;
            for (int j = 0; j < n; j++) {
                if (random.nextDouble() < p) {
                    successes++;
                }
            }
            sample[i] = successes;
        }
        return sample;
    }

    private static double[] generateUniformSample(double a, double b, int size) {
        Random random = new Random();
        double[] sample = new double[size];
        for (int i = 0; i < size; i++) {
            sample[i] = a + (b - a) * random.nextDouble();
        }
        return sample;
    }
    private static double[] generateExponentialSample(double alpha, int size) {
        Random random = new Random();
        double[] sample = new double[size];
        for (int i = 0; i < size; i++) {
            sample[i] = -Math.log(1 - random.nextDouble()) / alpha;
        }
        return sample;
    }
    private static double[] generateNormalSample(double mean, double stdDev, int size) {
        Random random = new Random();
        double[] sample = new double[size];
        for (int i = 0; i < size; i++) {
            sample[i] = mean + stdDev * random.nextGaussian();
        }
        return sample;
    }

    //Обчислюємо вибіркове середнє 
    private static double calculateMean(double[] data) {
        double sum = 0.0;
        for (double value : data) {
            sum += value;
        }
        return sum / data.length;
    }

    //Обчислюємо вибіркову дисперсію
    private static double calculateVariance(double[] data, double mean) {
        double sumSquaredDiff = 0.0;
        for (double value : data) {
            sumSquaredDiff += Math.pow(value - mean, 2);
        }
        return sumSquaredDiff / data.length;
    }
}
