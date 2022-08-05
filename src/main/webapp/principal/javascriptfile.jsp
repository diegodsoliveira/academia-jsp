<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Bootstrap script -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
<!--
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
-->
<script src="<%= request.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
<script src="<%= request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="<%= request.getContextPath()%>/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="<%= request.getContextPath()%>/vendor/datatables/jquery.dataTables.min.js"></script>
<script src="<%= request.getContextPath()%>/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="<%= request.getContextPath()%>/js/demo/datatables-demo.js"></script>

<!-- Page level plugins -->
<script src="<%= request.getContextPath()%>/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="<%= request.getContextPath()%>/js/demo/chart-area-demo.js"></script>
<script src="<%= request.getContextPath()%>/js/demo/chart-pie-demo.js"></script>
<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })
</script>