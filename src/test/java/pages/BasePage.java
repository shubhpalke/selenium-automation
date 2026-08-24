package pages;

import utils.*;

public class BasePage {

    protected ElementActions elementActions;
    protected MouseActions mouseActions;
    protected WindowUtils windowUtils;
    protected FrameUtils frameUtils;
    protected AlertUtils alertUtils;
    protected JSUtils jsUtils;

    public BasePage() {

        this.elementActions = new ElementActions();
        this.mouseActions = new MouseActions();
        this.windowUtils = new WindowUtils();
        this.frameUtils = new FrameUtils();
        this.alertUtils = new AlertUtils();
        this.jsUtils = new JSUtils();

    }
}
