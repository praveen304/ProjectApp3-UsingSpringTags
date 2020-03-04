package com.pk.service;

import java.util.List;

import com.pk.model.Part;

public interface PartService {

	public int savePart(Part ob);
	public List<Part> getAllParts();
	public void deletePart(Integer id);
	public Part getOnePart(Integer Id);
	public void updatePart(Part ob);
}
