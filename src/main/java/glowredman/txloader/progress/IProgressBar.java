package glowredman.txloader.progress;

public interface IProgressBar {

    void step(String message);

    void pop();

}
