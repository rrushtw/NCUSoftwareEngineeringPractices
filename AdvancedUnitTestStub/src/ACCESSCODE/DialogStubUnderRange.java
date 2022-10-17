package ACCESSCODE;

public class DialogStubUnderRange implements IDialog {

    private static DialogStubUnderRange Instance;

    private DialogStubUnderRange() {
    }

    public static DialogStubUnderRange GetInstance() {
        if (Instance == null) {
            Instance = new DialogStubUnderRange();
        }

        return Instance;
    }

    public int show() {
        return 0;
    }
}
