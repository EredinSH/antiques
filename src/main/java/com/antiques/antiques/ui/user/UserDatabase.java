package com.antiques.antiques.ui.user;

import com.antiques.antiques.bean.UserBean;
import com.antiques.antiques.model.User;
import org.omnifaces.cdi.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class UserDatabase implements Serializable {

    @Inject
    UserBean userBean;

    private List<User> values;

    public List<User> getValues() {
        if(values == null) {
            refresh();
        }
        return values;
    }

    public void refresh() {
        values = userBean.getAllUsers();
    }

}
