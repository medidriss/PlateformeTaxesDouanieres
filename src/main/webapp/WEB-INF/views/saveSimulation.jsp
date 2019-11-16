<%@ include file="taglibs.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simulation r�sultat</title>


    <script>
        $(document).ready(function () {
            $('[data-toggle="popover"]').popover();
        });
    </script>
</head>
<body>
<%@ include file="menuSimulation.jspf" %>
<div classs="container">
    <f:form modelAttribute="SimulationModel">
        <label> Nom Simulation</label>
        <f:input path="simulation.nomSimulation" value="${SimulationModel.simulation.nomSimulation }"
                 class="form-control"/>
        <label>Num�ro Simulation</label>
        <f:input path="simulation.idSimulation" value="${SimulationModel.simulation.idSimulation}" readonly="true"
                 class="form-control"/>
        <label>Date de Simulation</label>
        <input value="${SimulationModel.simulation.dateSimulation}" readonly="readonly" class="form-control"/>
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
                <th class="th-sm">Paiement

                </th>
                <th class="th-sm">Pays Origine

                </th>

            </tr>
            </thead>
            <tbody>

            <c:forEach items="${ SimulationModel.listeSimulationUnitaire }" var="elem" varStatus="i" begin="0">
            <tr>

                <td> ${elem.id.ndp }"</td>
                <td><a href="#" title="D�signation" data-toggle="popover" data-trigger="focus"
                       data-content="${SimulationModel.designations.get(elem.id.ndp)}"><i
                        class="material-icons">Voir</i></a>
                </td>

                <td><f:input value="${elem.prixAchat }" path="listeSimulationUnitaire[${i.index }].prixAchat"
                             class="form-control"/></td>
                <td><f:input value="${elem.quantite }" path="listeSimulationUnitaire[${i.index }].quantite"
                             class="form-control"/></td>
                <td><f:input value="${elem.montantUnitaire }"
                             path="listeSimulationUnitaire[${i.index }].montantUnitaire" class="form-control"/></td>
                <td><f:input readonly="true" value="${elem.paysOrigine.nomPays }"
                             path="listeSimulationUnitaire[${i.index }].paysOrigine.nomPays" class="form-control"/></td>


            </tr>
            </c:forEach>


        </table>
        <label>Montant Total � payer</label>
        <f:input readonly="true" value="${SimulationModel.simulation.montantTotale }" path="simulation.montantTotale"
                 class="form-control"/>
        <br><br>
        <br>
        <div class="btn-group col-md-6 col-md-offset-3 ">
            <a href="chercherNomenclature?simulation.idSimulation=${SimulationModel.simulation.idSimulation }"
               class="btn btn-primary" role="button">Modifier Simulation </a>
            <a href="ajouterSimulation" class="btn btn-primary" role="button">Sauvegarder </a>


        </div>

    </f:form>
</div>
</body>
</html>