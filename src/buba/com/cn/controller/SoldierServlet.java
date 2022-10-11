package buba.com.cn.controller;

import buba.com.cn.entity.Soldier;
import buba.com.cn.service.SoldierService;
import buba.com.cn.service.impl.SoldierServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SoldierServlet extends ViewBaseServlet{
    private SoldierService soldierService = new SoldierServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("method").equals("findAllSoldiers")){
            this.findAllSoldiers(req,resp);
        }if (req.getParameter("method").equals("addSoldiers")){
            this.addSoldiers(req,resp);
        }if (req.getParameter("method").equals("deleteSoldierById")){
            this.deleteSoldierById(req,resp);
        }if (req.getParameter("method").equals("updateSoldierById")){
            this.updateSoldierById(req,resp);
        }if (req.getParameter("method").equals("first")){
            this.first(req,resp);
        }
    }

    private void findAllSoldiers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Soldier> list = soldierService.findAllSoldiers();
        req.setAttribute("soldierList",list);
        processTemplate("list",req,resp);
    }

    private void addSoldiers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String soldierId = req.getParameter("username");
        String soldierId1 = req.getParameter("username1");
        Soldier soldier = new Soldier(soldierId, soldierId1);
        soldierService.addSoldiers(soldier);
        this.findAllSoldiers(req, resp);
    }

    private void deleteSoldierById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String soldierId = req.getParameter("id");
        soldierService.deleteSoldierById(Integer.valueOf(soldierId));
        this.findAllSoldiers(req, resp);
    }

    private void updateSoldierById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String soldierId = req.getParameter("id");
        getServletContext().setAttribute("id",soldierId);
        processTemplate("first",req,resp);
    }

    private void first(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String weapon = req.getParameter("weapon");
        Object id = getServletContext().getAttribute("id");
        Soldier soldier = new Soldier(Integer.valueOf((String) id), name, weapon);
        soldierService.updateSoldierById(soldier);
        this.findAllSoldiers(req, resp);
    }
}
