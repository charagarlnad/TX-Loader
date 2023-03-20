package glowredman.txloader.progress;

import java.lang.reflect.Field;

public class ProgressBarProxy {

    public static boolean isBLSLoaded;

    private static Class<?> ProgressDisplayer;
    private static Field displayer;

    public static IProgressBar get(String name, int maxSteps) {
        return (isBLSLoaded && isDisplayerAvailable()) ? new BLSProgressBar(name, maxSteps)
                : new FMLProgressBar(name, maxSteps);
    }

    public static boolean isDisplayerAvailable() {
        if (ProgressDisplayer == null) return false;

        if (displayer == null) {
            try {
                displayer = ProgressDisplayer.getDeclaredField("displayer");
            } catch (Exception ignored) {
                // This shouldn't be reached...
                // In case it is, cause early exits in the future
                isBLSLoaded = false;
                ProgressDisplayer = null;
                return false;
            }
        }

        try {
            return displayer.get(null) != null;
        } catch (Exception ignored) {
            return false;
        }
    }

    static {
        try {
            ProgressDisplayer = Class.forName("alexiil.mods.load.ProgressDisplayer");
        } catch (Exception ignored) {}
    }

    private ProgressBarProxy() {}

}
