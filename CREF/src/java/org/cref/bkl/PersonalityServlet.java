package org.cref.bkl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dustin
 */
public class PersonalityServlet extends HttpServlet {

    private static final ConcurrentHashMap<Integer, List<String>> questionMap = new ConcurrentHashMap<>();

    static {
        int i = 0;
        List<String> temp = new ArrayList<>();
        temp.add("SSKind, Nice, Caring");
        temp.add("BCProper, Formal");
        temp.add("DDDemanding, Asserting");
        temp.add("IIOutgoing, Active");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("BIPlayful, Fun-loving");
        temp.add("DBFirm, Strong");
        temp.add("CCLaw-abiding, Conscientious");
        temp.add("SSGentle, Soft, Humble");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("BDBold, Daring");
        temp.add("IBDelightful, Pleasant");
        temp.add("SSLoyal, True Blue");
        temp.add("CCCalculating, Analytical");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("CBConservative, Inflexible");
        temp.add("BITrusting, Gullible, Open");
        temp.add("SSPeaceful, Calm");
        temp.add("DDConvinced, Cocky");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("DDDecisive, Sure, Certain");
        temp.add("IIFriendly, Cordial, Popular");
        temp.add("CCCareful, Cautious");
        temp.add("SBObedient, Submissive");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("IIPromoting, Encouraging");
        temp.add("CBStraight, Conforming");
        temp.add("DDRisk-taking, Courageous");
        temp.add("BSPleasing, Good-natured");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("SBConsiderate, Thoughtful");
        temp.add("DDForceful, Strong-willed");
        temp.add("IIHyper, Energetic");
        temp.add("CCPerfectionist, Precise");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("SSContented, Statisfied");
        temp.add("BCCompliant, Goes by book");
        temp.add("DDBrave, Adventurous");
        temp.add("BIEnthusiastic, Influencing");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("BISmooth talker, Articulate");
        temp.add("BSLoving, Sincere, Honest");
        temp.add("DDPersistent, Restless, Relentless");
        temp.add("CCRight, Correct");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("DDPositive, Optimistic");
        temp.add("IIEntertaining, Clowning");
        temp.add("BSShy, Mild");
        temp.add("BCCompetent, Does Right");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("CBContemplative, Thinker");
        temp.add("SSDiplomatic, Peacemaking");
        temp.add("IBAdmirable, Elegant");
        temp.add("BDWinner, Competitive");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("BIJoyful, Jovial");
        temp.add("SSFlexible, Adaptable, Agreeable");
        temp.add("DDAmbitious, Goes for it");
        temp.add("BBDeep, Intense");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("SSSteady, Dependable");
        temp.add("IITalkative, Verbal");
        temp.add("DBChallenging, Motivating");
        temp.add("CBAccurate, Exact");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("SSStable, Balanced");
        temp.add("DBConfident, Self-reliant");
        temp.add("BCPerceptive, Sees Clearly");
        temp.add("IIAnimated, Expressive");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("DDControlling, Taking charge");
        temp.add("SSMerciful, Sensitive");
        temp.add("CCPondering, Wondering");
        temp.add("IBPersuading, Convincing");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("IBSociable, Interactive");
        temp.add("DDSerious, Unwavering");
        temp.add("SSSweet, Tender, Compassionate");
        temp.add("CBGuarded, Masked, Protective");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("DDPowerful, Unconquerable");
        temp.add("IIMerry, Cheerful");
        temp.add("SBGenerous, Giving");
        temp.add("CCPreparing, Researching");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("BSTimid, Soft-spoken");
        temp.add("BCSystematic, Follows plan");
        temp.add("DDIndustrious, Hard working");
        temp.add("IISmiling, Happy");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("CCInquisitive, Questioning");
        temp.add("SSTolerant, Patient");
        temp.add("DDDriving, Determined");
        temp.add("IIDynamic, Impressing");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("BSServing, Sacrificing");
        temp.add("IBSharp, Appealing");
        temp.add("DDDirect, To the point");
        temp.add("CCOriginal, Creative");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("IIPeppy, Playful");
        temp.add("BDDevoted, Dedicated");
        temp.add("SSCourteous, Polite");
        temp.add("CBStrict, Unbending");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("DDOutspoken, Opinionated");
        temp.add("IIInducing, Charming");
        temp.add("BCInventive, Imaginative");
        temp.add("SSHospitable, Enjoys company");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("DDZealous, Eager");
        temp.add("BBQiet, Reserved");
        temp.add("CCOrganized, Orderly");
        temp.add("IIExciting, Spirited");
        questionMap.put(++i, temp);

        temp = new ArrayList<>();
        temp.add("BCFaithful, Consistent");
        temp.add("IIResponsive, Reacting");
        temp.add("SSHelpful, Assisting");
        temp.add("DDBottom line, Straight-forward");
        questionMap.put(++i, temp);
    }

    public static String generateNewForm(String name, int questionNumber) {
        StringBuilder text = new StringBuilder("<html><head><title>Spiritual Gifts and Personality Assessment</title><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"></head><body>");
        if (questionNumber < questionMap.keySet().size()) {
            text.append("<form method=post action=\"/bkl/PersonalityServlet\">");
            text.append("<input type=\"hidden\" name=\"questionNumber\" value=\"").append(questionNumber + 1).append("\"/>");
            text.append("<input type=\"hidden\" name=\"userName\" value=\"").append(name).append("\"/>");
            text.append("<table border=\"1\">");

            text.append("<tr><td>M</td><td></td><td>L</td></tr>");
            List<String> temp = questionMap.get(questionNumber + 1);
            for (String s : temp) {
                text.append("<tr><td><input type=\"radio\" name=\"m\" value=\"" + s.charAt(0) + "\"></td><td>" + s.substring(2) + "</td><td><input type=\"radio\" name=\"l\" value=\"" + s.charAt(1) + "\"></td></tr>");
            }

            text.append("</table>");
            text.append("<button type=\"submit\">Submit</button>");
            text.append("</form>");
        } else {
            text.append("<h1>Total Boxes: (p. 12)</h1>");
            text.append(generateResults(name));
        }
        text.append("</body></html>");

        return text.toString();
    }

    public static String generateResults(String name) {
        StringBuilder text = new StringBuilder();
        ConcurrentHashMap<Integer, String> mAnswers = nameToMAnswersMap.get(name);

        ConcurrentHashMap<Integer, String> lAnswers = nameToLAnswersMap.get(name);
        int mD = 0;
        int mI = 0;
        int mS = 0;
        int mC = 0;

        int lD = 0;
        int lI = 0;
        int lS = 0;
        int lC = 0;

        for (Integer key : mAnswers.keySet()) {
            String mAnswer = mAnswers.get(key);
            if (mAnswer.equals("D")) {
                mD++;
            } else if (mAnswer.equals("I")) {
                mI++;
            } else if (mAnswer.equals("S")) {
                mS++;
            } else if (mAnswer.equals("C")) {
                mC++;
            }
        }
        for (Integer key : lAnswers.keySet()) {
            String lAnswer = lAnswers.get(key);
            if (lAnswer.equals("D")) {
                lD++;
            } else if (lAnswer.equals("I")) {
                lI++;
            } else if (lAnswer.equals("S")) {
                lS++;
            } else if (lAnswer.equals("C")) {
                lC++;
            }
        }

        text.append("<i>M:</i>D:<b>")
                .append(mD).append("</b> I:<b>")
                .append(mI).append("</b> S:<b>")
                .append(mS).append("</b> C:<b>")
                .append(mC).append("</b> <i>L:</i>D:<b>")
                .append(lD).append("</b> I:<b>")
                .append(lI).append("</b> S:<b>")
                .append(lS).append("</b> C:<b>")
                .append(lC).append("</b>");
        return text.toString();
    }

    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, String>> nameToMAnswersMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, String>> nameToLAnswersMap = new ConcurrentHashMap<>();

    static {
        ConcurrentHashMap<Integer, String> mAnswersMap = new ConcurrentHashMap<>();
        mAnswersMap.put(1, "I");
        mAnswersMap.put(2, "B");
        mAnswersMap.put(3, "C");
        mAnswersMap.put(4, "S");
        mAnswersMap.put(5, "C");
        mAnswersMap.put(6, "I");
        mAnswersMap.put(7, "S");
        mAnswersMap.put(8, "S");
        mAnswersMap.put(9, "C");
        mAnswersMap.put(10, "I");
        mAnswersMap.put(11, "C");
        mAnswersMap.put(12, "S");
        mAnswersMap.put(13, "S");
        mAnswersMap.put(14, "S");
        mAnswersMap.put(15, "C");
        mAnswersMap.put(16, "D");
        mAnswersMap.put(17, "S");
        mAnswersMap.put(18, "B");
        mAnswersMap.put(19, "C");
        mAnswersMap.put(20, "C");
        mAnswersMap.put(21, "B");
        mAnswersMap.put(22, "B");
        mAnswersMap.put(23, "D");
        mAnswersMap.put(24, "B");

        nameToMAnswersMap.put("Dustin", mAnswersMap);

        ConcurrentHashMap<Integer, String> lAnswersMap = new ConcurrentHashMap<>();
        lAnswersMap.put(1, "C");
        lAnswersMap.put(2, "B");
        lAnswersMap.put(3, "S");
        lAnswersMap.put(4, "D");
        lAnswersMap.put(5, "D");
        lAnswersMap.put(6, "B");
        lAnswersMap.put(7, "C");
        lAnswersMap.put(8, "D");
        lAnswersMap.put(9, "I");
        lAnswersMap.put(10, "S");
        lAnswersMap.put(11, "B");
        lAnswersMap.put(12, "D");
        lAnswersMap.put(13, "B");
        lAnswersMap.put(14, "C");
        lAnswersMap.put(15, "B");
        lAnswersMap.put(16, "B");
        lAnswersMap.put(17, "D");
        lAnswersMap.put(18, "S");
        lAnswersMap.put(19, "I");
        lAnswersMap.put(20, "D");
        lAnswersMap.put(21, "B");
        lAnswersMap.put(22, "I");
        lAnswersMap.put(23, "I");
        lAnswersMap.put(24, "I");
        
        nameToLAnswersMap.put("Dustin", lAnswersMap);
    }

    /*
     1L:C, 2L:B, 3L:S, 4L:D, 5L:D, 6L:B, 7L:C, 8L:D, 9L:I, 10L:S, 11L:B, 12L:D, 13L:B, 14L:C, 15L:B, 16L:B, 17L:D, 18L:S, 19L:I, 20L:D, 21L:B, 22L:I, 23L:I, 24L:I,
     */
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
            int questionNumber = Integer.valueOf((String) request.getParameter("questionNumber"));
            String mAnswer = (String) request.getParameter("m");
            String lAnswer = (String) request.getParameter("l");
            String name = (String) request.getParameter("userName");

            ConcurrentHashMap<Integer, String> mAnswers = nameToMAnswersMap.get(name);
            if (mAnswers == null) {
                mAnswers = new ConcurrentHashMap<>();
                nameToMAnswersMap.put(name, mAnswers);
            }
            mAnswers.put(questionNumber, mAnswer);

            ConcurrentHashMap<Integer, String> lAnswers = nameToLAnswersMap.get(name);
            if (lAnswers == null) {
                lAnswers = new ConcurrentHashMap<>();
                nameToLAnswersMap.put(name, lAnswers);
            }
            lAnswers.put(questionNumber, lAnswer);

            out.println(generateNewForm(name, questionNumber));
            out.println("<h4>");
            for (Integer key : mAnswers.keySet()) {
                out.println(key + "M:" + mAnswers.get(key) + ", ");
            }
            for (Integer key : lAnswers.keySet()) {
                out.println(key + "L:" + lAnswers.get(key) + ", ");
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
