//package Exercises.dsaProblems;
//
//import com.google.gson.Gson;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.eclipse.jetty.server.Request;
//import org.eclipse.jetty.server.Response;
//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.server.handler.AbstractHandler;
//import org.eclipse.jetty.util.Callback;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class PatientsMedicalRecordAPI {
//
//    public static void main(String[] args) throws Exception {
//        Server server = new Server(8080);
//        server.setHandler(new ApiHandler());
//        server.start();
//        System.out.println("Server started at http://localhost:8080/api/data");
//        server.join();
//    }
//
//    public static class ApiHandler extends AbstractHandler {
//
//        private final List<UserData> dummyData = generateDummyData();
//        private final Gson gson = new Gson();
//
//
//
//        private void handleApiData(HttpServletRequest request, HttpServletResponse response) throws IOException {
//            // Parse query parameters
//            String userIdParam = request.getParameter("userId");
//            String pageParam = request.getParameter("page");
//            String perPageParam = request.getParameter("per_page");
//
//            int userId = userIdParam != null ? Integer.parseInt(userIdParam) : 1;
//            int page = pageParam != null ? Integer.parseInt(pageParam) : 1;
//            int perPage = perPageParam != null ? Integer.parseInt(perPageParam) : 10;
//
//            // Filter data by userId
//            List<UserData> filteredData = dummyData.stream()
//                    .filter(data -> data.getUserId() == userId)
//                    .collect(Collectors.toList());
//
//            // Pagination logic
//            int total = filteredData.size();
//            int totalPages = (int) Math.ceil((double) total / perPage);
//            int start = (page - 1) * perPage;
//            int end = Math.min(start + perPage, total);
//
//            List<UserData> paginatedData = filteredData.subList(
//                    Math.min(start, total), Math.min(end, total));
//
//            // Create response object
//            ApiResponse apiResponse = new ApiResponse(page, perPage, total, totalPages, paginatedData);
//
//            // Send response
//            response.setContentType("application/json");
//            response.setStatus(HttpServletResponse.SC_OK);
//            response.getWriter().write(gson.toJson(apiResponse));
//        }
//
//        private List<UserData> generateDummyData() {
//            List<UserData> list = new ArrayList<>();
//            for (int i = 1; i <= 100; i++) {
//                list.add(new UserData(
//                        i,
//                        "User " + i,
//                        "01-01-19" + (90 + i % 10),
//                        i % 10,
//                        new Diagnosis(i % 5, "Diagnosis " + (i % 5), i % 3),
//                        new Vitals(120 + i, 80 + i, 70 + i, 20 + i % 5, 98.6 + i % 2)
//                ));
//            }
//            return list;
//        }
//
//        @Override
//        public boolean handle(Request request, Response response, Callback callback) throws Exception {
//            return false;
//        }
//
//    }
//
//    // Supporting classes
//    public static class ApiResponse {
//        private final int page;
//        private final int per_page;
//        private final int total;
//        private final int total_pages;
//        private final List<UserData> data;
//
//        public ApiResponse(int page, int per_page, int total, int total_pages, List<UserData> data) {
//            this.page = page;
//            this.per_page = per_page;
//            this.total = total;
//            this.total_pages = total_pages;
//            this.data = data;
//        }
//    }
//    @Data
//    public static class UserData {
//        private final int id;
//        private final String userName;
//        private final String userDob;
//        private final int userId;
//        private final Diagnosis diagnosis;
//        private final Vitals vitals;
//
//        public UserData(int id, String userName, String userDob, int userId, Diagnosis diagnosis, Vitals vitals) {
//            this.id = id;
//            this.userName = userName;
//            this.userDob = userDob;
//            this.userId = userId;
//            this.diagnosis = diagnosis;
//            this.vitals = vitals;
//        }
//    }
//
//    @Data
//    public static class Diagnosis {
//        private final int id;
//        private final String name;
//        private final int severity;
//
//        public Diagnosis(int id, String name, int severity) {
//            this.id = id;
//            this.name = name;
//            this.severity = severity;
//        }
//    }
//    @Data
//    public static class Vitals {
//        private final int bpDiastole;
//        private final int bpSystole;
//        private final int pulse;
//        private final int breathingRate;
//        private final double bodyTemperature;
//
//        public Vitals(int bpDiastole, int bpSystole, int pulse, int breathingRate, double bodyTemperature) {
//            this.bpDiastole = bpDiastole;
//            this.bpSystole = bpSystole;
//            this.pulse = pulse;
//            this.breathingRate = breathingRate;
//            this.bodyTemperature = bodyTemperature;
//        }
//    }
//}
