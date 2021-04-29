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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminLogin().setVisible(true);
            }
        });
    }
}
