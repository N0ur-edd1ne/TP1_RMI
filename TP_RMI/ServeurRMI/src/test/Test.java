/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;
import util.HibernateUtil;

public class Test {
    
    public static void main(String[] args) {
        try {
            IDao<Machine> daoMachine = new MachineService();
            
            daoMachine.create(new Machine("ER44", "HP", 4000));
            daoMachine.create(new Machine("ER46", "LENOVO", 6000));
            daoMachine.create(new Machine("ER48", "HP", 3000));
            
            daoMachine.create(new Machine("ER48", "DELL", 5000));
            daoMachine.create(new Machine("ER48", "SAMSUNG", 9000));
            daoMachine.create(new Machine("ER48", "ASUS", 2000));
            
            
            
            
            for(Machine  m : daoMachine.findAll())
                System.out.println(m);
            
            IDao<Salle> daoSalle = new SalleService();
            daoSalle.create(new Salle("s1"));
            daoSalle.create(new Salle("s2"));
            daoSalle.create(new Salle("s3"));
            daoSalle.create(new Salle("s4"));
            daoSalle.create(new Salle("s5"));
            daoSalle.create(new Salle("s6"));
            
            for(Salle s:daoSalle.findAll())
                System.out.println(s);
             for(Machine s:daoMachine.findMachineBySalle(1))
                System.out.println(s);
        } catch (RemoteException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}