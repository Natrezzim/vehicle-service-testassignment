package ru.testassignment.vehicleservice.controller;

import com.itextpdf.text.DocumentException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.testassignment.vehicleservice.dto.Vehicle;
import ru.testassignment.vehicleservice.service.VehicleService;
import ru.testassignment.vehicleservice.service.utility.PdfGenerator;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

  private final VehicleService vehicleService;

  @Autowired
  public VehicleController(VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  @GetMapping
  public List<Vehicle> findAllVehicles() {
    return vehicleService.findAllVehicles();
  }

  @GetMapping(value = "/")
  public List<Vehicle> findVehiclesByFields(@RequestParam Integer ownerId,
      @RequestParam Integer brandId, @RequestParam Integer modelId) {
    return vehicleService.findVehiclesByFields(ownerId, brandId, modelId);
  }

  @PutMapping
  public int updateVehicle(@RequestBody Vehicle updateVehicle) {
    return vehicleService.updateVehicle(updateVehicle);
  }

  @PostMapping
  public Long newVehicle(@RequestBody Vehicle newVehicle) {
    return vehicleService.createVehicle(newVehicle);
  }

  @DeleteMapping
  public int deleteVehicle(@RequestBody Vehicle deleteVehicle) {
    return vehicleService.deleteVehicle(deleteVehicle);
  }

  @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
  public ResponseEntity pdfExport() throws DocumentException, IOException {
    ByteArrayInputStream bis = PdfGenerator.customerPDFReport(vehicleService.pdfExport());
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Disposition", "inline; filename=vehicles.pdf");

    return ResponseEntity
        .ok()
        .headers(headers)
        .contentType(MediaType.APPLICATION_PDF)
        .body(new InputStreamResource(bis));
  }

}
