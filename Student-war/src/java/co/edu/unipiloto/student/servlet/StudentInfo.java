/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.servlet;

import co.edu.unipiloto.student.entity.Course;
import co.edu.unipiloto.student.entity.Coursespk;
import co.edu.unipiloto.student.entity.CoursespkPK;
import co.edu.unipiloto.student.entity.Student;
import co.edu.unipiloto.student.session.CourseFacadeLocal;
import co.edu.unipiloto.student.session.CoursespkFacadeLocal;
import co.edu.unipiloto.student.session.StudentFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osmal
 */
@WebServlet(name = "StudentInfo", urlPatterns = {"/StudentInfo"})
public class StudentInfo extends HttpServlet {

    @EJB
    private CoursespkFacadeLocal coursespkFacade;

    @EJB
    private CourseFacadeLocal courseFacade;

    @EJB
    private StudentFacadeLocal studentFacade;
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String action = request.getParameter("action");
            String studentIdStr = request.getParameter("studentId");
                int studentId = Integer.parseInt(studentIdStr);
                String firstName = request.getParameter("firstname");
                String lastName = request.getParameter("lastname");
                String yearLevelStr = request.getParameter("yearLevel");
                int yearLevel = Integer.parseInt(yearLevelStr);
                Student estudiante = new Student(studentId, firstName, lastName, yearLevel);
                
                
                String courseIdStr = request.getParameter("courseId");
                int courseId = Integer.parseInt(courseIdStr);
                String name = request.getParameter("coursename");
                String creditosStr = request.getParameter("numcreditos");
                int creditos = Integer.parseInt(creditosStr);
                String semestreStr = request.getParameter("semestre");
                int semestre = Integer.parseInt(semestreStr);
                Course curso = new Course(courseId, name, creditos, semestre, null);
                
                Coursespk coursepk = new Coursespk(studentId, courseId);
            
            if (action.equals("Add")){
                studentFacade.addStudent(estudiante);
                courseFacade.addCourse(curso);
                coursespkFacade.addCoursepk(coursepk);
            }
            else if (action.equals("Edit")){
                studentFacade.editStudent(estudiante);
                courseFacade.editCourse(curso);
                coursespkFacade.editCoursepk(coursepk);
                
            }
            else if (action.equals("Delete")){
                studentFacade.deleteStudent(studentId);
                courseFacade.deleteCourse(courseId);
                coursespkFacade.deleteCoursepk(studentId);
            }
            else {
                estudiante = studentFacade.getStudent(studentId);
                curso = courseFacade.getCourse(courseId);
            }
            request.setAttribute("student", estudiante);
            request.setAttribute("allStudent", studentFacade.getAllStudents());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentInfo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentInfo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
