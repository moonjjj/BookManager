<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <section class="search-container">
      <div class="search">
        <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
          <form action="bookSearch" method="get">
            <div class="form-row">
              <div class="col-12 col-md-9 mb-2 mb-md-0">
                <input
                  type="text"
                  id="bname"
                  name="bname"
                  class="form-control form-control-lg"
                  placeholder="Ã¥ÀÌ¸§ ¾²¼ÀÃó"
                />
              </div>
              <div class="col-12 col-md-3">
                <button type="submit" class="btn btn-block btn-lg btn-primary">
                  <i class="fas fa-search"></i>
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </section>