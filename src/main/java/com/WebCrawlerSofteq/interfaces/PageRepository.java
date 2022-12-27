package com.WebCrawlerSofteq.interfaces;


import com.WebCrawlerSofteq.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Page, Long> {
}
