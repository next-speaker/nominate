<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
    <meta name="layout" content="dialog"/>
    <title>${team?.description}</title>
    <style>
    .carousel {
        background: #2f4357;
        margin-top: 20px;
    }

    .carousel-item {
        text-align: center;
        min-height: 280px; /* Prevent carousel from being distorted if for some reason image doesn't load */
    }
    </style>
</head>

<body>
<div class="container-lg my-3">
    <h2 class="font-weight-light">${team.description}</h2>

    <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="0">
        <!-- Carousel indicators -->
        <ol class="carousel-indicators">
            <g:each in="${members}" var="m" status="idx">
                <li data-target="#myCarousel" data-slide-to="${idx}" class="${idx == 0 ? 'active' : ''}"></li>
            </g:each>
        </ol>
        <!-- Wrapper for carousel items -->
        <div class="carousel-inner">
            <g:each in="${members}" var="m" status="idx">
                <div class="carousel-item ${idx == 0 ? 'active' : ''}">
                    <div class="d-flex justify-content-center align-middle">
                        <div class="card" style="width: 18rem;">
                            <div class="card-body">
                                <h5 class="card-title">Now</h5>
                                <h3 class="card-text">${m}</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </g:each>
        </div>
        <!-- Carousel controls -->
        <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>
</div>
</body>
</html>