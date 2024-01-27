package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        long partsCounter = partRepository.count();
        long productsCounter = productRepository.count();

        if(partsCounter == 0) {

            OutsourcedPart o = new OutsourcedPart();
            OutsourcedPart o2 = new OutsourcedPart();
            OutsourcedPart o3 = new OutsourcedPart();
            OutsourcedPart o4 = new OutsourcedPart();
            OutsourcedPart o5 = new OutsourcedPart();

            o.setCompanyName("Malek's Computer Shop");

            o.setName("Motherboard");
            o2.setName("CPU (Processor)");
            o3.setName("GPU (Graphics Card)");
            o4.setName("RAM (Memory)");
            o5.setName("Storage (SSD/HDD)");

            o.setInv(45);
            o2.setInv(80);
            o3.setInv(30);
            o4.setInv(50);
            o5.setInv(65);

            o.setMaxInv(50);
            o2.setMaxInv(95);
            o3.setMaxInv(40);
            o4.setMaxInv(25);
            o5.setMaxInv(70);

            o.setMinInv(1);
            o2.setMinInv(1);
            o3.setMinInv(1);
            o4.setMinInv(1);
            o5.setMinInv(1);

            o.setPrice(120.0);
            o2.setPrice(250.0);
            o3.setPrice(350.0);
            o4.setPrice(80.0);
            o5.setPrice(100.0);

            o.setId(100L);
            o2.setId(101L);
            o3.setId(102L);
            o4.setId(103L);
            o5.setId(104L);

            outsourcedPartRepository.save(o);
            outsourcedPartRepository.save(o2);
            outsourcedPartRepository.save(o3);
            outsourcedPartRepository.save(o4);
            outsourcedPartRepository.save(o5);
        }

        OutsourcedPart thePart = null;
        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts) {
            if (part.getName().equals("CPU (Processor)")) {
                thePart = part;
            } else if (part.getName().equals("GPU (Graphics Card)")) {
                thePart = part;
            } else if (part.getName().equals("RAM (Memory)")) {
                thePart = part;
            } else if (part.getName().equals("Storage (SSD/HDD)")) {
                thePart = part;
            } else if (part.getName().equals("Motherboard")) {
                thePart = part;
            }
        }

        System.out.println(thePart.getCompanyName());
        //

        List<OutsourcedPart> outsourcedParts_2 = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts_2) {
            System.out.println(part.getName() + " " + part.getCompanyName());
        }

        if(productsCounter == 0) {
            Product gamingPC = new Product("Gaming PC", 1500.0, 5);
            Product businessPC = new Product("Business Workstation", 1200.0, 10);
            Product homeOfficePC = new Product("Home Office PC", 800.0, 12);
            Product mediaCenterPC = new Product("Media Center PC", 1000.0, 8);
            Product budgetPC = new Product("Budget Student PC", 600.0, 15);
            productRepository.save(gamingPC);
            productRepository.save(businessPC);
            productRepository.save(homeOfficePC);
            productRepository.save(mediaCenterPC);
            productRepository.save(budgetPC);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products" + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts" + partRepository.count());
        System.out.println(partRepository.findAll());
    }
}




