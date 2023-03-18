package glowredman.txloader.progress;

public class ProgressBarProxy {

    public static boolean isBLSLoaded;

    public static IProgressBar get(String name, int maxSteps) {
        return isBLSLoaded ? new BLSProgressBar(name, maxSteps) : new FMLProgressBar(name, maxSteps);
    }

    private ProgressBarProxy() {}

}
