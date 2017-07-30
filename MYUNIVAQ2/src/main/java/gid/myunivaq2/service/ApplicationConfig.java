/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq2.service;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author ASUS TRONY
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(gid.myunivaq2.jpa.StudenteResource.class);
        resources.add(gid.myunivaq2.service.service.AppelloFacadeREST.class);
        resources.add(gid.myunivaq2.service.service.AulaFacadeREST.class);
        resources.add(gid.myunivaq2.service.service.CorsoDiLaureaFacadeREST.class);
        resources.add(gid.myunivaq2.service.service.EsamiSvoltiFacadeREST.class);
        resources.add(gid.myunivaq2.service.service.MateriaFacadeREST.class);
        resources.add(gid.myunivaq2.service.service.ProfessoreFacadeREST.class);
        resources.add(gid.myunivaq2.service.service.StudenteFacadeREST.class);
        resources.add(gid.myunivaq2.service.service.TassaFacadeREST.class);
    }
    
}
