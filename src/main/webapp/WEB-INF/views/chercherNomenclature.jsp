<%@ include file="taglibs.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simulation</title>

</head>
<body>
<%@ include file="menu.jspf" %>

<div class="col-md-4">


    <div class="panel panel-primary">
        <div class="panel-heading"><h2>Recherche de Nomenclature</h2></div>
        <div class="panel-body">
            <div>
                <f:form action="chercherNomenclature" modelAttribute="SimulationModel" method="get">
                    <div class="form-group">
                        <label>Reherche par NDP :</label>
                        <f:input path="rechercheNDP"/>
                    </div>
                    <f:hidden path="simulation.idSimulation" value="${SimulationModel.simulation.idSimulation }"
                              readonly="true"/>

                    <div class="form-group">
                        <label>Reherche par Mot Cl� :</label>
                        <f:input path="rechercheMotCle"/>
                    </div>
                    <f:button value="chercher" class="btn btn-info">chercher</f:button>
                </f:form>
            </div>
        </div>
    </div>


    <div class="panel panel-primary">
        <div class="panel-heading"><h2>Informations de Simulation </h2></div>
        <div class="panel-body">

            <f:form modelAttribute="SimulationModel">


            </f:form>
            <div>
                <label>Liste Simulation Unitaire</label>

                <table id="dtBasicExample" class="table table-striped table-bordered table-sm">
                    <thead>

                    <tr>
                        <th class="th-sm">NDP

                        </th>

                        <th class="th-sm">Supprimer le choix

                        </th>

                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${ pageSimulationUnitaire }" var="elem">
                    <tr>
                        <td> ${elem.id.ndp } </td>

                        <td>
                            <a href="supprimerNdpDuListe?idSimulation=${SimulationModel.simulation.idSimulation }&ndp=${elem.id.ndp }"
                               class="btn btn-info" role="button"> Supprimer</a></td>


                    </tr>
                    </c:forEach>

                </table>
            </div>


            <ul class="nav nav-pills">

                <c:forEach items="${ nbPagesSimulationUnitaire }" var="item">
                    <li>
                        <a href="chercherNomenclature?simulation.idSimulation=${SimulationModel.simulation.idSimulation }&page=${page}&size=${size}&p=${item}&s=${s}"> ${item } </a>
                    </li>
                </c:forEach>

            </ul>

        </div>
    </div>


</div>


<div class="col-md-6">

    <div class="container">
        <div class="panel panel-primary">
            <div class="panel-heading"><h2>Liste des Nomenclatures</h2></div>
            <div class="panel-body">


                <f:form>

                    <table id="dtBasicExample" class="table table-striped table-bordered table-sm">
                        <thead>

                        <tr>
                            <th class="th-sm">NDP

                            </th>
                            <th class="th-sm">D�signation

                            </th>
                            <th class="th-sm">Add

                            </th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pages}" var="item">
                        <tr>
                            <td>${item.ndp } </td>
                            <td> ${item.designation }</td>
                            <td>
                                <a href="chercherNomenclature?simulation.idSimulation=${SimulationModel.simulation.idSimulation}&rechercheNDP=${item.ndp }&rechercheMotCle=${SimulationModel.rechercheMotCle }&page=${page}&size=${size}&p=${p}&s=${s}"
                                   class="btn btn-info far fa-plus-square style='font-size:36px'" role="button"> </a>
                            </td>


                        </tr>
                        </c:forEach>

                    </table>

                </f:form>


                <div>
                    <ul class="nav nav-pills">

                        <c:forEach items="${nbPages}" var="item">
                            <li>
                                <a href="chercherNomenclature?simulation.idSimulation=${SimulationModel.simulation.idSimulation }&rechercheNDP=${SimulationModel.rechercheNDP }&rechercheMotCle=${SimulationModel.rechercheMotCle }&page=${item}&size=${size}&p=${p}&s=${s}"> ${item } </a>
                            </li>
                        </c:forEach>

                    </ul>
                </div>
            </div>

            <div class="panel panel-primary">
                <div class="panel-heading"><h4>Compl�ter Les Informations</h4></div>
                <div class="panel-body">
                    <label> Sauvegarder les choix </label>
                    <a href="completerSimulationForm?idSimulation=${SimulationModel.simulation.idSimulation }"
                       class="btn btn-info" role="button">Sauvegarder, Compl�ter Les Informations </a>
                </div>
            </div>


        </div>
    </div>

</div>


</body>
</html>