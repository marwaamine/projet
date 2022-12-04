
package controllers;

import com.google.gson.Gson;
import entities.Categorie;
import entities.Marque;
import entities.Produit;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.metamodel.SetAttribute;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import services.CategorieServices;
import services.MarqueServices;
import services.ProduitServices;

/**
 *
 * @author faouzia
 */
@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
      String nom ;
     String designation ;
     String description ;
     double prix ;
     int unite ;
      int idmarque ;
      int idcategorie;
    String path;
    
    private String UPLOAD_DIRECTORY;

    private ProduitServices produitServices;
    private Marque marque;
    private MarqueServices marqueServices;
    private CategorieServices categorieServices;

    public void init() {
        marqueServices = new MarqueServices();
        produitServices = new ProduitServices();
        categorieServices = new CategorieServices();
    }
    protected void FormProduit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Marque> marques = marqueServices.findMarques();
        request.setAttribute("marques", marques);
        List<Categorie> categories = categorieServices.listCategories();
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("admin/AddProduct");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url[] = request.getPathInfo().split("/");
        String action = url[1];
        switch (action) {
            case "FormProduct":
                FormProduit(request, response);
                break;
            case "AddProduct":
                AddProduct(request, response);
                break;
            case "FormCategorie":
                FormCategorie(request, response);
                break;
            case "AddCategorie":
                AddCategorie(request, response);
                break;
            case "FormMarque":
                FormMarque(request, response);
                break;
            case "AddMarque":
                AddMarque(request, response);
                break;
            case "produits":
                getProduit(request, response);
                break;
            case "listMarques":
                listMarques(request, response);
                break;
            case "deleteMarque":
                deleteMarque(request, response);
                break;
            case "listeCategories":
                listeCategories(request, response);
                break;
            case "deleteCategorie":
                deleteCategorie(request, response);
                break;
            case "listProduits":
                listProduits(request, response);
                break;
            case "deleteProduit":
                deleteProduit(request, response);
                break;
            default:
                FormProduit(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void AddProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
    UPLOAD_DIRECTORY = getServletContext().getRealPath("/").replace("build\\", "") + "ressource" + File.separator + "images";
          if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
               String name = null;
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {  
                        name = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                        path = UPLOAD_DIRECTORY + File.separator + name;
                    } else {
                        InputStream input = item.getInputStream(); 
                        if (item.getFieldName().equals("nom")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            nom= new String(str, "UTF8");
                        }
                          if (item.getFieldName().equals("designation")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            designation= new String(str, "UTF8");
                        }
                            if (item.getFieldName().equals("description")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                           description= new String(str, "UTF8");
                        }
                             if (item.getFieldName().equals("prix")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            prix = Double.parseDouble(new String(str, "UTF8"));
                        }
                             if (item.getFieldName().equals("unite")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            unite = Integer.parseInt(new String(str, "UTF8"));
                        }
                             if (item.getFieldName().equals("categories")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            idcategorie= Integer.parseInt(new String(str, "UTF8"));
                        }
                             if (item.getFieldName().equals("marques")) {
                            byte[] str = new byte[input.available()];
                            input.read(str);
                            idmarque=Integer.parseInt(new String(str, "UTF8"));
                        }
                    }
                }
                //File uploaded successfully
       Marque m = marqueServices.findMarqueById(idmarque);
      Categorie c = categorieServices.findCategorieById(idcategorie);
      if(produitServices.AddProduit(new Produit(nom, description, designation, prix, name, unite, m, c)))
      {
         // request.setAttribute("message", "File Uploaded Successfully le nom est :" + nom+ " le prenom est :" + prix);
         // response.getWriter().append("Produit bien ajouté");
           response.sendRedirect("../produits.jsp");
      }
      else 
          response.getWriter().append("errrrrror ");
            } catch (Exception ex) {
                response.getWriter().append("noo");
               // request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
              response.getWriter().append("message Sorry this Servlet only handles file upload request");
            //request.setAttribute("message",
                //    "Sorry this Servlet only handles file upload request");
        }
    
    }

    private void getProduit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produit> produits = produitServices.findAllProduits();
        request.setAttribute("produits", produits);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/test.jsp");
        dispatcher.forward(request, response);
    }

    private void FormCategorie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/categorieform.jsp");
        dispatcher.forward(request, response);
    }

    private void AddCategorie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String categorie = request.getParameter("categorie");
        if (categorieServices.AddCategorie(new Categorie(categorie))) {
            response.getWriter().append("Categorie bien ajouté");
        }
    }

    private void FormMarque(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/marqueform.jsp");
        dispatcher.forward(request, response);
    }

    private void AddMarque(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String marque = request.getParameter("marque");
        if (marqueServices.AddMarque(new Marque(marque))) {
            //response.getWriter().append("Marque bien ajouté");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/marques.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void listMarques(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();
        List<MarqueDTO> m = new ArrayList<>();

        marqueServices.findMarques().forEach(x -> {
            m.add(new MarqueDTO(x));
        });
        System.out.println(m);
        response.getWriter().write(gson.toJson(m));

    }

    private void listeCategories(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();
        List<CategorieDTO> m = new ArrayList<>();

        categorieServices.listCategories().forEach(x -> {
            m.add(new CategorieDTO(x));
        });
        System.out.println(m);
        response.getWriter().write(gson.toJson(m));        
        
    }
    
    private void listProduits(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        Gson gson = new Gson();
        List<ProduitDTO> m = new ArrayList<>();

        produitServices.findAllProduits().forEach(x -> {
            m.add(new ProduitDTO(x));
        });
        System.out.println(m);
        response.getWriter().write(gson.toJson(m));              
        
    }    

    private void deleteMarque(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            marqueServices.deleteMarque(marqueServices.findMarqueById(id));
        } catch (NumberFormatException e) {
        }
        listMarques(request, response);
    }



    private void deleteProduit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            produitServices.deleteProduit(produitServices.findProduitById(id));
        } catch (NumberFormatException e) {
        }
        listProduits(request, response);
    }

    private void deleteCategorie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            categorieServices.deleteCategorie(categorieServices.findCategorieById(id));
        } catch (NumberFormatException e) {
        }
        listeCategories(request, response);

    }

}
