//This uses the singleton Pattern to help manage Forms
public class FormManager {

    private static FormManager Instance;
    private MainGUI InitialForm;
    private AdminGUI AdminForm;

    private FormManager(){

    }
    public static FormManager getInstance(){
        if(Instance == null){
            Instance = new FormManager();


        }
        return Instance;

    }
    public void setInitialForm(MainGUI newForm){
        InitialForm = newForm;
    }
    public void setAdminForm(AdminGUI newForm){
        AdminForm = newForm;
    }
    public AdminGUI getAdminForm(){
        return AdminForm;
    }
    public MainGUI getInitialForm(){
        return InitialForm;
    }
}
