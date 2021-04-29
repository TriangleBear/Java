/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userPass;

/**
 *
 * @author ACER 
 */
public class runner {
    public static void main(String[] args) {
        UsernamePasswords up = new UsernamePasswords();
        adminLogin lp = new adminLogin(up.getLoginInfo());
        new adminLogin().setVisible(true);
    }
}
