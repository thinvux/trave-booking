package com.vti.repository;

import com.vti.dto.BookingTourDTO;
import com.vti.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface BookingRepository extends JpaRepository<Booking, String>, JpaSpecificationExecutor<Booking> {

    Booking findByMaBooking(int maBooking);

    List<Booking> findByNameKH(String nameKH);

    @Query("SELECT b.thoiGianDat AS date, COUNT(b) AS count FROM Booking b GROUP BY b.thoiGianDat")
    List<Map<String, Object>> countBookingsByDay();

    @Modifying
    @Query("DELETE FROM Booking WHERE maBooking = :maBooking")
    void deleteById(int maBooking);


}
