<%@ include file="taglibs.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Completer Simulation</title>


    <script>
        $(document).ready(function () {
            $('[data-toggle="popover"]').popover();
        });
    </script>
</head>
<body>
<%@ include file="menuSimulation.jspf" %>
<div classs="container">

    <div class="panel panel-primary">
        <div class="panel-heading"><h2>Les Informations de Simulation</h2></div>
        <div class="panel-body">

            <f:form modelAttribute="SimulationModel" method="post" action="saveSimulation">

                <label> Nom Simulation</label>
                <f:input path="simulation.nomSimulation" value="${SimulationModel.simulation.nomSimulation }"
                         class="form-control"/>
                <label>Num�ro Simulation</label>
                <f:input path="simulation.idSimulation" value="${SimulationModel.simulation.idSimulation}"
                         readonly="true" class="form-control"/>
                <label> Nom User </label>
                <f:input path="simulation.user.nom" value="${SimulationModel.simulation.user.nom}" readonly="true"
                         class="form-control"/>
                <label> Pr�nom User </label>
                <f:input path="simulation.user.prenom" value="${SimulationModel.simulation.user.prenom}" readonly="true"
                         class="form-control"/>


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

                        <f:input readonly="true" hidden="true" value="${elem.id.idSimulation}"
                                 path="listeSimulationUnitaire[${i.index }].id.idSimulation"/>
                        <td><f:input readonly="true" value="${elem.id.ndp}"
                                     path="listeSimulationUnitaire[${i.index }].id.ndp"/></td>


                        <td><a href="#" title="D�signation" data-toggle="popover" data-trigger="focus"
                               data-content="${SimulationModel.designations.get(elem.id.ndp)}"><i
                                class="material-icons">Voir</i></a>
                        </td>


                        <td><f:input value="${elem.prixAchat }"
                                     path="listeSimulationUnitaire[${i.index }].prixAchat"/></td>
                        <td><f:input value="${elem.quantite }"
                                     path="listeSimulationUnitaire[${i.index }].quantite"/></td>
                        <td>

                            <f:select path="listeSimulationUnitaire[${i.index }].paysOrigine">
                                <c:forEach items="${ listPays}" var="item">
                                    <f:option value="${item }"> ${item.nomPays }</f:option>
                                </c:forEach>
                            </f:select>
                        </td>
                    </tr>
                    </c:forEach>


                </table>
                <label><h4>Lancer Calcul : </h4></label>
                <br>
                <f:button class="btn btn-info">Calculer Simulation</f:button>

            </f:form>
        </div>
    </div>


</div>

</body>
</html>