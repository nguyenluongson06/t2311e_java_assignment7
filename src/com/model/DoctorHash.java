package com.model;

import java.util.ArrayList;

public class DoctorHash {
    /**
     * virtual Database
     */
    private ArrayList<Doctor> data;
    /**
     * Initial
     * @param data virtual Database
     */
    public DoctorHash(ArrayList<Doctor> data) {
        this.data = data;
    }
    /**
     * check Availability valid (>0)
     * @param availability of doctor
     * @return number
     * @throws Exception state check
     */
    public int checkAvailability(String availability) throws Exception {
        try {
            if (Integer.parseInt(availability) >= 0) {
                return Integer.parseInt(availability);
            } else {
                throw new Exception("Availability must be higher than 0");
            }
        } catch (NumberFormatException e) {
            throw new Exception("Availability must be a number");
        } catch (Exception e) {
            throw new Exception("Invalid Availability");
        }
    }
    /**
     * add new doctor into database
     * @param doctor information doctor
     * @return state add new
     * @throws Exception add new
     */
    public boolean addDoctor(Doctor doctor) throws Exception {
        try {
            if (data == null) {
                throw new Exception("Database doesn't exist");
            } else if (doctor == null) {
                throw new Exception("Data doesn't exist");
            } else {
                boolean duplicate = false;
                for (Doctor d : data) {
                    if (d.getCode().equals(doctor.getCode())) {
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate) {
                    throw new Exception("Doctor code is duplicated");
                } else {
                    data.add(doctor);
                }
            }
        } catch (Exception e) {
            throw new Exception("Cannot add new doctor");
        }
        return true;
    }
    /**
     * update doctor into database
     * @param doctor information doctor
     * @return state update
     * @throws Exception update
     */
    public boolean updateDoctor(Doctor doctor) throws Exception {
        try {
            if (data == null) {
                throw new Exception("Database doesn't exist");
            } else if (doctor == null) {
                throw new Exception("Data doesn't exist");
            } else {
                boolean duplicate = false;
                for (Doctor d : data) {
                    if (d.getCode().equals(doctor.getCode())) {
                        d.setName(doctor.getName());
                        d.setSpecialization(doctor.getSpecialization());
                        d.setAvailability(doctor.getAvailability());
                        duplicate = true;
                        break;
                    }
                }
                if (!duplicate) {
                    throw new Exception("Doctor code does not exist");
                }
            }
        } catch (Exception e) {
            throw new Exception("Cannot add new doctor");
        }
        return true;
    }
    /**
     * remover doctor in database
     * @param doctor information doctor
     * @return state delete
     * @throws Exception delete
     */
    public boolean deleteDoctor(Doctor doctor) throws Exception {
        try {
            if (data == null) {
                throw new Exception("Database doesn't exist");
            } else if (doctor == null) {
                throw new Exception("Data doesn't exist");
            } else {
                boolean duplicate = false;
                for (Doctor d : data) {
                    if (d.getCode().equals(doctor.getCode())) {
                        data.remove(d);
                        duplicate = true;
                        break;
                    }
                }
                if (!duplicate) {
                    throw new Exception("Doctor code does not exist");
                }
            }
        } catch (Exception e) {
            throw new Exception("Cannot delete doctor");
        }
        return true;
    }
    /**
     * Find doctor in database
     * @param input key find all attribute of Doctor
     * @return List Doctor
     * @throws Exception state Search
     */
    public ArrayList<Doctor> searchDoctor(String input) throws Exception {
        ArrayList<Doctor> result = new ArrayList<>();
        try {
            if (data == null) {
                throw new Exception("Database doesn't exist");
            } else if (input == null) {
                throw new Exception("Search query is null");
            } else {
                for (Doctor d : data) {
                    if (d.getName().contains(input) || d.getSpecialization().contains(input) || d.getCode().contains(input)) {
                        result.add(d);
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("Search query failed");
        }
        return result;
    }
}