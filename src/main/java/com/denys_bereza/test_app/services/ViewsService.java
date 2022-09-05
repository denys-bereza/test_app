package com.denys_bereza.test_app.services;

import com.denys_bereza.test_app.models.Views;

import java.util.List;
import java.util.UUID;

public interface ViewsService {
    public Views addView();
    public List<Views> fetchViews(UUID id);
}
