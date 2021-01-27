package Controller;

import Model.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditItemButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Boolean changesMade = false;
        if(FormManager.getInstance().getAdminForm().getStockList().getSelectedIndex() != -1){
            Item itemtoChange = FormManager.getInstance().getItemFromCode(FormManager.getInstance().getAdminForm().getRestockList().get(FormManager.getInstance().getAdminForm().getStockList().getSelectedIndex()).getCode());

            if(FormManager.getInstance().getItemFromCode(FormManager.getInstance().getAdminForm().getCodeTextField().getText()) == null){
                if(!FormManager.getInstance().getAdminForm().getCodeTextField().getText().equals("")){
                    itemtoChange.setCode(FormManager.getInstance().getAdminForm().getCodeTextField().getText());
                    changesMade = true;

                }
                if(!FormManager.getInstance().getAdminForm().getNameTextField().getText().equals("")){
                    itemtoChange.setName(FormManager.getInstance().getAdminForm().getNameTextField().getText());
                    changesMade = true;

                }
                if(!FormManager.getInstance().getAdminForm().getPrice£TextField().getText().equals("")){
                    try{
                        itemtoChange.setPrice(Float.parseFloat(FormManager.getInstance().getAdminForm().getPrice£TextField().getText()));
                        changesMade = true;

                    }
                    catch (Exception error){
                        FormManager.getInstance().getAdminForm().getStateLabel().setText("An error occurred, please double-check the price input");

                    }


                }
                if(!FormManager.getInstance().getAdminForm().getStockTextField().getText().equals("")){
                    try{
                        itemtoChange.setAmountInStock(Integer.parseInt(FormManager.getInstance().getAdminForm().getStockTextField().getText()));
                        changesMade = true;

                    }
                    catch (Exception error){
                        FormManager.getInstance().getAdminForm().getStateLabel().setText("An error occurred, please double-check the stock input");

                    }


                }


            }
            else{
                FormManager.getInstance().getAdminForm().getStateLabel().setText("Identical code exists, ensure that the code is unique");
            }





        }
        else if(!FormManager.getInstance().getAdminForm().getCodeTextField().getText().equals("")){
            if(!FormManager.getInstance().getAdminForm().getNameTextField().getText().equals("")){
                FormManager.getInstance().getItemFromCode(FormManager.getInstance().getAdminForm().getCodeTextField().getText()).setName(FormManager.getInstance().getAdminForm().getNameTextField().getText());
                changesMade = true;
            }
            if(!FormManager.getInstance().getAdminForm().getPrice£TextField().getText().equals("")){
                try{
                    FormManager.getInstance().getItemFromCode(FormManager.getInstance().getAdminForm().getCodeTextField().getText()).setPrice(Float.parseFloat(FormManager.getInstance().getAdminForm().getPrice£TextField().getText()));
                    changesMade = true;

                }
                catch (Exception error){
                    FormManager.getInstance().getAdminForm().getStateLabel().setText("An error occurred, please double-check the price input");

                }


            }
            if(!FormManager.getInstance().getAdminForm().getStockTextField().getText().equals("")){
                try{
                    FormManager.getInstance().getItemFromCode(FormManager.getInstance().getAdminForm().getCodeTextField().getText()).setAmountInStock(Integer.parseInt(FormManager.getInstance().getAdminForm().getStockTextField().getText()));
                    changesMade = true;

                }
                catch (Exception error){
                    FormManager.getInstance().getAdminForm().getStateLabel().setText("An error occurred, please double-check the stock input");

                }


            }
        }
        else{
            FormManager.getInstance().getAdminForm().getStateLabel().setText("No changes made. Be sure to select the item from the list or input the code in the boxes above");

        }

        if(changesMade){
            FormManager.getInstance().getAdminForm().getStateLabel().setText("Changes have been made");
            FormManager.getInstance().updateItemCSV();
            FormManager.getInstance().getAdminForm().populateRestockArea();

        }

    }
}
