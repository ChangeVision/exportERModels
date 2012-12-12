package com.change_vision.astah.apisample;

import static java.lang.String.format;

import java.io.File;

import com.change_vision.jude.api.inf.model.IERAttribute;
import com.change_vision.jude.api.inf.model.IERDomain;
import com.change_vision.jude.api.inf.model.IEREntity;
import com.change_vision.jude.api.inf.model.INamedElement;

public class ERModelCSVExporter {

    private File modelFile;
    private AstahAPIWrapper util = new AstahAPIWrapper();
    
    public static void main(String[] args) {
        if(args.length != 1){
            System.err.println("Usage: java -cp [astah-api.jar and astah-pro.jar path] com.change_vision.astah.apisample.ERModelCSVExporter [target astah model]");
            System.exit(1);
        }
        String filePath = args[0];
        File file = new File(filePath);
        ERModelCSVExporter exporter = new ERModelCSVExporter(file);
        exporter.export();
    }

    public ERModelCSVExporter(File modelFile) {
        this.modelFile = modelFile;
        if(modelFile.exists() == false) throw new IllegalStateException();
    }

    /**
     * 指定したファイルからERModel情報を出力します。
     * export ERModel information from specified model.
     */
    public void export() {
        util.open(modelFile);
        printDomain();
        System.out.println();
        printEntity();
        util.close();
    }

    /**
     * ドメインを出力します。
     * Print domain information
     */
    private void printDomain() {
        System.out.println("Domains");
        INamedElement[] domains = util.findElements(IERDomain.class);
        System.out.println("Name,Datatype,Length");
        for (INamedElement element : domains) {
            if (element instanceof IERDomain) {
                IERDomain domain = (IERDomain) element;
                System.out.println(format("%s,%s,%s", domain.getName(),domain.getDatatypeName(),domain.getLengthPrecision()));
            }
        }
    }

    /**
     * エンティティを出力します。
     * Print Entity information
     */
    private void printEntity() {
        System.out.println("Entities");
        INamedElement[] entities = util.findElements(IEREntity.class);
        for (INamedElement element : entities) {
            if (element instanceof IEREntity) {
                IEREntity entity = (IEREntity) element;
                System.out.println("\"Logical Name\",\"Phisycal Name\"");
                System.out.println(format("\"%s\",\"%s\"", entity.getLogicalName(),entity.getPhysicalName()));
                System.out.println();
                System.out.println("PKs");
                System.out.println("\"PK?\",\"Logical Name\",\"Phisycal Name\",\"Datatype\"");
                IERAttribute[] pks = entity.getPrimaryKeys();
                for (IERAttribute pk : pks) {
                    System.out.println(format("PK,%s,%s %s",pk.getLogicalName(),pk.getPhysicalName(),pk.getDatatype().getName()));
                }
                IERAttribute[] nonPrimaryKeys = entity.getNonPrimaryKeys();
                for (IERAttribute nonpk : nonPrimaryKeys) {
                    System.out.println(format("  ,%s,%s %s",nonpk.getLogicalName(),nonpk.getPhysicalName(),nonpk.getDatatype().getName()));
                }
                System.out.println();
            }
        }
    }

}
