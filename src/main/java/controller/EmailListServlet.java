package controller;

import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Nhan du lieu tu form co action="emaillist" method="post".
 * URL cuoi cung se la: http://<host>:<port>/<context>/emaillist
 */
@WebServlet("/emaillist")
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Doc du lieu tu form, kiem tra null de tranh loi
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String source = request.getParameter("source");                 // radio
        String offers = request.getParameter("offers");                 // checkbox (null neu khong check)
        String emailAnnouncements = request.getParameter("emailAnnouncements"); // checkbox
        String contact = request.getParameter("contact");               // select

        // In ra console (log) de kiem tra, ban co the thay bang code luu vao DB
        System.out.println("=== Du lieu khao sat nhan duoc ===");
        System.out.println("Ho ten: " + firstName + " " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Ngay sinh: " + dateOfBirth);
        System.out.println("Biet den qua: " + source);
        System.out.println("Muon lam fan Ronaldo: " + (offers != null));
        System.out.println("Nhan email thong bao: " + (emailAnnouncements != null));
        System.out.println("Lien he qua: " + contact);

        // Tra ket qua ve trinh duyet
        response.setContentType("text/html; charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><meta charset='UTF-8'><title>Cam on</title>");
            out.println("<link rel='stylesheet' href='styles/main.css'></head><body>");
            out.println("<h1>Cam on ban da tham gia khao sat!</h1>");
            out.println("<p><strong>Ho ten:</strong> " + escape(firstName) + " " + escape(lastName) + "</p>");
            out.println("<p><strong>Email:</strong> " + escape(email) + "</p>");
            out.println("<p><strong>Ngay sinh:</strong> " + escape(dateOfBirth) + "</p>");
            out.println("<p><strong>Biet den qua:</strong> " + escape(source) + "</p>");
            out.println("<p><strong>Muon lam fan Ronaldo:</strong> " + (offers != null ? "Co" : "Khong") + "</p>");
            out.println("<p><strong>Nhan email thong bao:</strong> " + (emailAnnouncements != null ? "Co" : "Khong") + "</p>");
            out.println("<p><strong>Lien he qua:</strong> " + escape(contact) + "</p>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Neu co nguoi truy cap truc tiep bang GET, chi bao ho dung form
        response.setContentType("text/plain; charset=UTF-8");
        response.getWriter().println("Vui long gui du lieu qua form (POST), khong truy cap truc tiep.");
    }

    // Ham nho de tranh loi XSS khi in du lieu nguoi dung ra HTML
    private String escape(String value) {
        if (value == null) return "";
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }
}