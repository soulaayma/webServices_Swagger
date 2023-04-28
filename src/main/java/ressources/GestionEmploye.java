package ressources;


import entity.Etudiant;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("employees")
@Api
public class GestionEmploye {
    public static List<Etudiant> etudiants = new ArrayList<Etudiant>();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get All Employees")
    @ApiResponses({
            @ApiResponse(code=200,message = "Success")
    })

    public List<Etudiant> displayEmployeesList(){
        return etudiants;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Adding an employee")
    @ApiResponses({
            @ApiResponse(code=200,message = "Success")
    })

    public void addEmployee (@ApiParam(required = true) Etudiant e){
        etudiants.add(e);
    }

    @PUT
    @Path("{cin}")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Updating an employee")
    @ApiResponses({
            @ApiResponse(code=204, message="Success"),
            @ApiResponse(code=404, message="Not Found")
    })
    public void updateEmployee (	@ApiParam(required = true) @PathParam("cin") String cin,
                                    @ApiParam(required = true) Etudiant e){
        Etudiant emp = searchEtudiant(cin);
        emp.setNom(e.getNom());
        emp.setPrenom(e.getPrenom());
    }
    @GET
    @Path("{CIN}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get All Employees")
    @ApiResponses({
            @ApiResponse(code=200,message = "Success")
    })
    public Etudiant searchEtudiant(@ApiParam(required = true)@PathParam(value = "CIN") String cin){
        Etudiant e =null;
        for(int i=0;i<etudiants.size();i++){
            if(etudiants.get(i).getCin().equals(cin)){
                e= etudiants.get(i);
            }
        }
        return e;
    }
    @DELETE
    @Path("{CIN}")
    @ApiOperation(value="Removes an employee")
    @ApiResponses({
            @ApiResponse(code=204, message="Success"),
            @ApiResponse(code=404, message="Not Found")
    })
    public void deleteEmployee(@ApiParam(required = true)@PathParam(value = "CIN") String cin){
        etudiants.remove(searchEtudiant(cin));
    }
}
