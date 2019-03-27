package org.cref.bkl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SpiritualGiftServlet extends HttpServlet {

    static String generateNewForm(String name, int questionNumber) {
        StringBuilder text = new StringBuilder("<html><head><title>Spiritual Gifts and Personality Assessment</title><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></head><body>");
        if (questionNumber < 128) {//128
            text.append("<h1>Question ").append(questionNumber + 1).append(":</h1>");
            text.append("<form method=post action=\"/bkl/SpiritualGiftServlet\">");
            text.append("<input type=\"hidden\" name=\"questionNumber\" value=\"").append(questionNumber + 1).append("\"/>");
            text.append("<input type=\"hidden\" name=\"userName\" value=\"").append(name).append("\"/>");
            text.append("<input type=\"hidden\" name=\"questionAnswer\" value=\"").append(1).append("\"/>");
            text.append("<button type=\"submit\">&nbsp;&nbsp;&nbsp;&nbsp;<font size=5>").append(1).append("</font>&nbsp;&nbsp;&nbsp;&nbsp;</button> - Almost Never.");
            text.append("</form>");

            text.append("<form method=post action=\"/bkl/SpiritualGiftServlet\">");
            text.append("<input type=\"hidden\" name=\"questionNumber\" value=\"").append(questionNumber + 1).append("\"/>");
            text.append("<input type=\"hidden\" name=\"userName\" value=\"").append(name).append("\"/>");
            text.append("<input type=\"hidden\" name=\"questionAnswer\" value=\"").append(2).append("\"/>");
            text.append("<button type=\"submit\">&nbsp;&nbsp;&nbsp;&nbsp;<font size=5>").append(2).append("</font>&nbsp;&nbsp;&nbsp;&nbsp;</button> - Seldom.");
            text.append("</form>");

            text.append("<form method=post action=\"/bkl/SpiritualGiftServlet\">");
            text.append("<input type=\"hidden\" name=\"questionNumber\" value=\"").append(questionNumber + 1).append("\"/>");
            text.append("<input type=\"hidden\" name=\"userName\" value=\"").append(name).append("\"/>");
            text.append("<input type=\"hidden\" name=\"questionAnswer\" value=\"").append(3).append("\"/>");
            text.append("<button type=\"submit\">&nbsp;&nbsp;&nbsp;&nbsp;<font size=5>").append(3).append("</font>&nbsp;&nbsp;&nbsp;&nbsp;</button> - Sometimes. (try to avoid this answer)");
            text.append("</form>");

            text.append("<form method=post action=\"/bkl/SpiritualGiftServlet\">");
            text.append("<input type=\"hidden\" name=\"questionNumber\" value=\"").append(questionNumber + 1).append("\"/>");
            text.append("<input type=\"hidden\" name=\"userName\" value=\"").append(name).append("\"/>");
            text.append("<input type=\"hidden\" name=\"questionAnswer\" value=\"").append(4).append("\"/>");
            text.append("<button type=\"submit\">&nbsp;&nbsp;&nbsp;&nbsp;<font size=5>").append(4).append("</font>&nbsp;&nbsp;&nbsp;&nbsp;</button> - Often.");
            text.append("</form>");

            text.append("<form method=post action=\"/bkl/SpiritualGiftServlet\">");
            text.append("<input type=\"hidden\" name=\"questionNumber\" value=\"").append(questionNumber + 1).append("\"/>");
            text.append("<input type=\"hidden\" name=\"userName\" value=\"").append(name).append("\"/>");
            text.append("<input type=\"hidden\" name=\"questionAnswer\" value=\"").append(5).append("\"/>");
            text.append("<button type=\"submit\">&nbsp;&nbsp;&nbsp;&nbsp;<font size=5>").append(5).append("</font>&nbsp;&nbsp;&nbsp;&nbsp;</button> - Almost Always.");
            text.append("</form>");
        } else {
            text.append("<h1>Numerical Ratings Chart (p. 5)</h1>");
            text.append(generateResults(name, true));
            text.append("<br/><form method=post action=\"/bkl/GetNamePersonalityServlet\">\n"
                    + "            <input type=\"hidden\" name=\"name\" value=\"" + "\"/><br/>\n"
                    + "            <button type=\"submit\">Begin Personality Questionnaire</button>\n"
                    + "        </form>");
        }
        text.append("</body></html>");

        return text.toString();
    }

    public static ConcurrentHashMap<String, ConcurrentHashMap<Integer, Integer>> nameToAnswersMap = new ConcurrentHashMap<>();

    static {
        ConcurrentHashMap<Integer, Integer> answerMap = new ConcurrentHashMap<>();
        answerMap.put(1, 2);
        answerMap.put(2, 1);
        answerMap.put(3, 2);
        answerMap.put(4, 4);
        answerMap.put(5, 2);
        answerMap.put(6, 4);
        answerMap.put(7, 1);
        answerMap.put(8, 5);
        answerMap.put(9, 3);
        answerMap.put(10, 1);
        answerMap.put(11, 3);
        answerMap.put(12, 4);
        answerMap.put(13, 4);
        answerMap.put(14, 5);
        answerMap.put(15, 5);
        answerMap.put(16, 5);
        answerMap.put(17, 2);
        answerMap.put(18, 2);
        answerMap.put(19, 4);
        answerMap.put(20, 5);
        answerMap.put(21, 3);
        answerMap.put(22, 3);
        answerMap.put(23, 3);
        answerMap.put(24, 4);
        answerMap.put(25, 5);
        answerMap.put(26, 5);
        answerMap.put(27, 1);
        answerMap.put(28, 4);
        answerMap.put(29, 4);
        answerMap.put(30, 5);
        answerMap.put(31, 5);
        answerMap.put(32, 3);
        answerMap.put(33, 3);
        answerMap.put(34, 4);
        answerMap.put(35, 4);
        answerMap.put(36, 4);
        answerMap.put(37, 5);
        answerMap.put(38, 2);
        answerMap.put(39, 4);
        answerMap.put(40, 3);
        answerMap.put(41, 5);
        answerMap.put(42, 1);
        answerMap.put(43, 1);
        answerMap.put(44, 4);
        answerMap.put(45, 4);
        answerMap.put(46, 5);
        answerMap.put(47, 4);
        answerMap.put(48, 4);
        answerMap.put(49, 5);
        answerMap.put(50, 1);
        answerMap.put(51, 2);
        answerMap.put(52, 4);
        answerMap.put(53, 4);
        answerMap.put(54, 3);
        answerMap.put(55, 5);
        answerMap.put(56, 4);
        answerMap.put(57, 4);
        answerMap.put(58, 2);
        answerMap.put(59, 1);
        answerMap.put(60, 4);
        answerMap.put(61, 4);
        answerMap.put(62, 5);
        answerMap.put(63, 5);
        answerMap.put(64, 4);
        answerMap.put(65, 2);
        answerMap.put(66, 3);
        answerMap.put(67, 2);
        answerMap.put(68, 1);
        answerMap.put(69, 5);
        answerMap.put(70, 4);
        answerMap.put(71, 4);
        answerMap.put(72, 2);
        answerMap.put(73, 5);
        answerMap.put(74, 4);
        answerMap.put(75, 4);
        answerMap.put(76, 2);
        answerMap.put(77, 4);
        answerMap.put(78, 5);
        answerMap.put(79, 3);
        answerMap.put(80, 5);
        answerMap.put(81, 2);
        answerMap.put(82, 2);
        answerMap.put(83, 2);
        answerMap.put(84, 1);
        answerMap.put(85, 1);
        answerMap.put(86, 5);
        answerMap.put(87, 4);
        answerMap.put(88, 4);
        answerMap.put(89, 5);
        answerMap.put(90, 5);
        answerMap.put(91, 5);
        answerMap.put(92, 4);
        answerMap.put(93, 4);
        answerMap.put(94, 4);
        answerMap.put(95, 2);
        answerMap.put(96, 1);
        answerMap.put(97, 4);
        answerMap.put(98, 1);
        answerMap.put(99, 3);
        answerMap.put(100, 2);
        answerMap.put(101, 5);
        answerMap.put(102, 4);
        answerMap.put(103, 4);
        answerMap.put(104, 5);
        answerMap.put(105, 5);
        answerMap.put(106, 5);
        answerMap.put(107, 4);
        answerMap.put(108, 1);
        answerMap.put(109, 1);
        answerMap.put(110, 3);
        answerMap.put(111, 4);
        answerMap.put(112, 5);
        answerMap.put(113, 5);
        answerMap.put(114, 3);
        answerMap.put(115, 2);
        answerMap.put(116, 2);
        answerMap.put(117, 5);
        answerMap.put(118, 3);
        answerMap.put(119, 4);
        answerMap.put(120, 4);
        answerMap.put(121, 4);
        answerMap.put(122, 3);
        answerMap.put(123, 1);
        answerMap.put(124, 1);
        answerMap.put(125, 2);
        answerMap.put(126, 2);
        answerMap.put(127, 3);
        answerMap.put(128, 3);
        nameToAnswersMap.put("Dustin", answerMap);
    }

    public static String generateResults(String name, boolean listAnswers) {
        ConcurrentHashMap<Integer, Integer> resultMap = new ConcurrentHashMap<>();
        ConcurrentHashMap<Integer, Integer> answers = nameToAnswersMap.get(name);
        StringBuilder text = new StringBuilder();
        if (listAnswers) {
            text.append("<table border=1><tr>");
        }
        for (Integer key : answers.keySet()) {
            int column = key % 16;
            if (listAnswers) {
                text.append("<td>" + answers.get(key) + "&nbsp;&nbsp;</td>");
            }
            if (resultMap.get(column) == null) {
                resultMap.put(column, answers.get(key));
            } else {
                resultMap.put(column, resultMap.get(column) + answers.get(key));
            }
            if (listAnswers) {
                if (key % 16 == 0) {
                    text.append("</tr><tr>");
                }
            }
        }

        Integer s = resultMap.remove(0);
        for (Integer key : resultMap.keySet()) {
            if (listAnswers) {
                text.append("<td><b>");
            }

            text.append(resultMap.get(key));
            if (listAnswers) {
                text.append("</b></td>");
            } else {
                text.append(", ");
            }
        }
        if (listAnswers) {
            text.append("<td><b>");
        }
        text.append(s);
        if (listAnswers) {
            text.append("</b></td>");
        }
        if (listAnswers) {
            text.append("</tr></table><br/>");
        }

        return text.toString();
    }

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
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SpiritualGiftServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SpiritualGiftServlet at " + request.getContextPath() + "</h1>");
//            try {
//                out.println("<h1>userName " + request.getParameter("userName") + "</h1>");
//                out.println("<h1>questionNumber " + request.getParameter("questionNumber") + "</h1>");
//                out.println("<h1>questionAnswer " + request.getParameter("questionAnswer") + "</h1>");
//                String name = (String) request.getParameter("name");
//                String number = (String) request.getParameter("questionNumber");
//                String answer = (String) request.getParameter("questionAnswer");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            out.println("</body>");
//            out.println("</html>");
            int questionNumber = Integer.valueOf((String) request.getParameter("questionNumber"));
            int answer = Integer.valueOf((String) request.getParameter("questionAnswer"));
            String name = (String) request.getParameter("userName");
            ConcurrentHashMap<Integer, Integer> answers = nameToAnswersMap.get(name);
            if (answers == null) {
                answers = new ConcurrentHashMap<>();
                nameToAnswersMap.put(name, answers);
            }
            answers.put(questionNumber, answer);

            out.println(generateNewForm(name, questionNumber));
            out.println("<h4>");
            for (Integer key : answers.keySet()) {
                out.println(key + ":" + answers.get(key) + ", ");
            }
            out.println("</h4>");
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
