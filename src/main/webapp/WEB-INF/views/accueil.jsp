<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css"/>" />
<meta charset="UTF-8">
<title>Bienvenue</title>
</head>
<body>
	<div class="div">
		<c:import url="entete.jsp"/>
	</div>
	<div class="div">
		<table>
			<tr>
				<td valign="top" align="left"><c:import url="profil.jsp"></c:import>
				</td>
				<td><div class="divContenu">
						<table>
							<c:choose>
								<c:when test="${post.idPage==1}">
									<c:forEach items="${categories}" var="i">
										<tr>
											<td colspan="2" class="border"><a
												href="${pageContext.servletContext.contextPath}/categorie/${i.id}">
													${i.description}</a></td>
										</tr>
									</c:forEach>

									<tr>
										<td colspan="2" class="border"><hr>Veuillez remplir
											le formulaire ci-dessous pour ajouter une nouvelle catégorie
											:</td>
									</tr>
								</c:when>
								<c:when test="${post.idPage==2}">
									<c:forEach items="${sousCategories}" var="i">
										<tr>
											<td colspan="2" class="border"><a
												href="${pageContext.servletContext.contextPath}/sousCategorie/${i.id}">
													${i.description}</a></td>
										</tr>
									</c:forEach>

									<tr>
										<td colspan="2" class="border"><hr>Veuillez remplir
											le formulaire ci-dessous pour ajouter une nouvelle sous
											catégorie :</td>
									</tr>
								</c:when>
								<c:when test="${post.idPage==3}">
									<c:forEach items="${sujets}" var="i">
										<tr>
											<td class="border" width="100"><a
												href="${pageContext.servletContext.contextPath}/sujet/${i.id}">
													${i.intitule}</a></td>
											<td class="border" width="450"><a
												href="${pageContext.servletContext.contextPath}/sujet/${i.id}">
													${i.contenu}</a></td>
											
										</tr>
									</c:forEach>
									<tr>
										<td colspan="2" class="border">Veuillez remplir
											le formulaire ci-dessous pour ajouter un nouveau sujet :</td>
									</tr>
								</c:when>
								<c:when test="${post.idPage==4}">
									<!--AZ modif BEGIN-->
									
									<tr>
										<td colspan="2" class="border">
											<table>
												<tr>
													<c:forEach items="${suggestion}" var="i">
														<td>
															<div class="sug" style="padding: 2px 6px 3px 6px;
															    background: #6be320;
															    color: brown;
															    border-radius: 3px;
															    box-shadow: 1px 1px 4px 0px black;">
																<a href="${pageContext.servletContext.contextPath}/categorie/${i.getCategorie().getId()}">
																${i.getCategorie().getDescription()}</a>
																|
																<a href="${pageContext.servletContext.contextPath}/sousCategorie/${i.getSousCategorie().getId()}">
																 ${i.getSousCategorie().getDescription()}</a>
															</div>
														</td>
													</c:forEach>
												</tr>
											</table>
										</td>
									</tr>
									<!--AZ modif END-->
									<c:forEach items="${reponses}" var="i">
										<tr>
											<td class="border">${i.auteur.nom}<br>
											    <c:choose>
													<c:when test="${i.auteur.photo!=null}">
														<img
															src="${pageContext.servletContext.contextPath}/photoAuteur?id=${i.auteur.id}"
															WIDTH=50 HEIGHT=50>
													</c:when>
													<c:when test="${i.auteur.sexe=='F'}">
														<img src="<c:url value="/resources/images/profilF.png"/>"
															WIDTH=50 HEIGHT=50>
													</c:when>
													<c:when test="${i.auteur.sexe=='M'}">
														<img src="<c:url value="/resources/images/profilH.png"/>"
															WIDTH=50 HEIGHT=50>
													</c:when>
												</c:choose> <br> ${i.datePost}
											</td>
											<td width="450"  class="border">${i.contenu}</td>
										</tr>
									</c:forEach>
									<tr>
										<td colspan="2"  class="border"><hr>Veuillez remplir le formulaire
											ci-dessous pour ajouter une nouvelle réponse :</td>
									</tr>
									<%-- <c:set var="id" value="${4}" /> --%>
								</c:when>
							</c:choose>
						</table>
					</div> <form:form modelAttribute="post" method="post"
						action="${pageContext.servletContext.contextPath}/addPost/${post.id}/${post.idPage}"
						cssClass="form">
						<table>
							<c:if test="${not empty erreurBean}">
								<tr>
									<td colspan="2"><span class="erreur">${erreurBean.message}</span></td>
								</tr>
							</c:if>
							<c:if test="${post.idPage==3 || post.idPage==4 }">
								<tr>
									<td colspan="2">Avertissez-moi des nouveaux commentaires
										par email. <form:checkbox value="" path="notifCreateur" />
									</td>
								</tr>
							</c:if>
							<c:if test="${post.idPage==3}">
								<tr>
									<td colspan="2">Titre: <form:input path="intitule"
											size="80" /></td>
								</tr>
							</c:if>
							<tr>
								<td>Message:<form:textarea path="contenu" cols="60"
										rows="4" />
								</td>
								<td><input class="send" type="submit" name="send" value=" " />
									<br> <input class="refresh" type="submit" name="refr"
									value=" " /> <!-- Notify me of new posts via email. --></td>
							</tr>
						</table>
					</form:form></td>
			</tr>
		</table>
	</div>
</body>
</html>