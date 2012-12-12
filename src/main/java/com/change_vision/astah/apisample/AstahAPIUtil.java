package com.change_vision.astah.apisample;

import java.io.File;
import java.io.IOException;

import com.change_vision.jude.api.inf.exception.LicenseNotFoundException;
import com.change_vision.jude.api.inf.exception.NonCompatibleException;
import com.change_vision.jude.api.inf.exception.ProjectLockedException;
import com.change_vision.jude.api.inf.exception.ProjectNotFoundException;
import com.change_vision.jude.api.inf.model.INamedElement;
import com.change_vision.jude.api.inf.project.ProjectAccessor;
import com.change_vision.jude.api.inf.project.ProjectAccessorFactory;

public class AstahAPIUtil {
    
    private ProjectAccessor getProjectAccessor(){
        try {
            return  ProjectAccessorFactory.getProjectAccessor();
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Maybe it does not contain astah-pro.jar in your classpath.",e);
        }
    }
    
    /**
     * プロジェクトを開きます。
     * open specified project.
     * @param file
     */
    public void open(File file){
        ProjectAccessor projectAccessor = getProjectAccessor();
        try {
            projectAccessor.open(file.getAbsolutePath());
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Maybe it does not contain astah-pro.jar in your classpath.",e);
        } catch (LicenseNotFoundException e) {
            throw new IllegalStateException("License not found.",e);
        } catch (ProjectNotFoundException e) {
            throw new IllegalStateException("Projecte not found.",e);
        } catch (NonCompatibleException e) {
            throw new IllegalStateException("API version is older than the version of astah* this project has been edited with.",e);
        } catch (IOException e) {
            throw new IllegalStateException("Maybe it does not open the file.",e);
        } catch (ProjectLockedException e) {
            throw new IllegalStateException("Project is locked.",e);
        }
    }

    /**
     * 指定したモデルクラスの要素を取得します。
     * find elements of specified model class.
     * @param clazz
     * @return model elements
     */
    public INamedElement[] findElements(Class<?> clazz) {
        try {
            return (INamedElement[]) getProjectAccessor().findElements(clazz);
        } catch (ProjectNotFoundException e) {
            throw new IllegalStateException("Projecte not found.",e);
        }
    }

    /**
     * プロジェクトを閉じます。
     * close project.
     */
    public void close() {
        getProjectAccessor().close();
    }

}
