<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>service</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
<f:form modelAttribute="SimulationModel">
    <label> Nom Simulation</label>
    <f:input path="simulation.nomSimulation" value="${SimulationModel.simulation.nomSimulation }" class="form-control"/>
    <label>Num�ro Simulation</label>
    <f:input path="simulation.idSimulation" value="${SimulationModel.simulation.idSimulation}" readonly="true"
             class="form-control"/>
    <label>Date de Simulation</label>
    <input value="${SimulationModel.simulation.dateSimulation}" readonly="true" class="form-control"/>
    <label> Nom User </label>
    <f:input path="simulation.user.nom" value="${SimulationModel.simulation.user.nom}" readonly="true"
             class="form-control"/>
    <label> Pr�nom User </label>
    <f:input path="simulation.user.nom" value="${SimulationModel.simulation.user.nom}" readonly="true"
             class="form-control"/>
</f:form>


<f:form modelAttribute="SimulationModel">
    <table id="dtBasicExample" class="table table-striped table-bordered table-sm">
        <thead>

        <tr>
            <th class="th-sm">NDP

            </th>
            <th class="th-sm">D�signation

            </th>
            <th class="th-sm"> Prix Hors TAXE

            </th>
            <th class="th-sm">Quantit�

            </th>
            <th class="th-sm">Pays Origine

            </th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${ SimulationModel.listeSimulationUnitaire }" var="elem" varStatus="i" begin="0">
        <tr>

            <td><f:input value="${elem.nomenclature.ndp }"
                         path="listeSimulationUnitaire[${i.index }].nomenclature.ndp"/></td>
            <td><f:input value="${elem.nomenclature.designation }"
                         path="listeSimulationUnitaire[${i.index }].nomenclature.designation"/></td>
            <td><f:input value="${elem.prixAchat }" path="listeSimulationUnitaire[${i.index }].prixAchat"
                         class="form-control"/></td>
            <td><f:input value="${elem.quantite }" path="listeSimulationUnitaire[${i.index }].quantite"
                         class="form-control"/></td>
            <td><f:input readonly="true" value="${elem.paysOrigine.nomPays }"
                         path="listeSimulationUnitaire[${i.index }].paysOrigine.nomPays" class="form-control"/></td>


        </tr>
        </c:forEach>


    </table>
</f:form>

</body>
</html>