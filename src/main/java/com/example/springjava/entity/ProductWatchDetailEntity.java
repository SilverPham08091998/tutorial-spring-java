package com.example.springjava.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity(name = "PRODUCT_WATCH_DETAIL")
@Table(name = "PRODUCT_WATCH_DETAIL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductWatchDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    // Tên sản phẩm : iPhone 14 Pro 128GB | Chính hãng VN/A-Đen
    @Column(name = "name")
    private String name;

    // Tên sản phẩm : iPhone 14 Pro 128GB | Chính hãng VN/A-Đen
    @Column(name = "title")
    private String title;

    // Nội dung : Trải ngiêm ấn tượng ...
    @Column(name = "content")
    private String content;

    //Màu
    @Column(name = "color")
    private String color;


    //Độ phân giải : 2556 x 1179 pixels
    @Column(name = "display_resolution")
    private String displayResolution;

    //Kích thước : 48
    @Column(name = "display_size")
    private String displaySize;

    //Loại màn hình:  OLED
    @Column(name = "display_type")
    private String displayType;

    //Kích thước cụ thể : dài rộng dày
    @Column(name = "dimensions")
    private String dimensions;

    //Pin
    @Column(name = "battery")
    private String battery;

    // Bluetooth
    @Column(name = "bluetooth")
    private String bluetooth;

    //Nhà phát hành
    @Column(name = "manufacturer")
    private String manufacturer;

    // Chip
    @Column(name = "chip_set")
    private String chipSet;

    // khung viền
    @Column(name = "material")
    private String material;

    // mặt kính
    @Column(name = "front_material")
    private String frontMaterial;

    // cảm biến
    @Column(name = "sensor")
    private String sensor;

    // tần số quét
    @Column(name = "frequency")
    private String frequency;

    // công nghệ sạc: sạc nhanh , Magsafe
    @Column(name = "charging")
    private String charging;

    // cổng sạc
    @Column(name = "gate_charging")
    private String gateCharging;

    // kháng nước bụi bẩn :IP68
    @Column(name = "resistance")
    private String resistance;

    // tính năng : Hỗ trợ 5G, Sạc không dây, Nhận diện khuôn mặt, Kháng nước, kháng bụi
    @Column(name = "feature")
    private String feature;

    // tính năng đặc biệt : Hỗ trợ 5G, Sạc không dây, Nhận diện khuôn mặt, Kháng nước, kháng bụi
    @Column(name = "special_feature")
    private String special_feature;
    // Âm thanh
    @Column(name = "sound")
    private String sound;
    // Mô tả sản phầm
    @Column(name = "description")
    private String description;
    // hệ diều hành
    @Column(name = "operation_system")
    private String operationSystem;

    // độ sáng 300 cd/m2
    @Column(name = "brightness")
    private String brightness;

    // độ sáng 300 cd/m2
    @Column(name = "feature_heathy")
    private String featureHealthy;

    // trọng lượng
    @Column(name = "weight")
    private String weight;

    @Column(name = "urlImage")
    private String urlImage;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productEntity;
}
