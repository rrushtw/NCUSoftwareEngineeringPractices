package ACCESSCODE;

public class DialogStubOverRange implements IDialog {

    private static DialogStubOverRange Instance;

    private DialogStubOverRange() {
    }

    public static DialogStubOverRange GetInstance() {
        if (Instance == null) {
            Instance = new DialogStubOverRange();
        }

        return Instance;
    }

    public int show() {
        return 24;
    }
}
